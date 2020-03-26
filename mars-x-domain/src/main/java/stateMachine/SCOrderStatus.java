package stateMachine;

/**
 * SkyScanner 订单状态
 */
public enum SCOrderStatus {

    /**
     * 订单不存在
     */
    ORDER_UNKNOWN("UNKNOWN", false),

    /**
     * 支付失败
     */
    PAYMENT_FAILED("PAYMENTFAILED", true),

    /**
     * 支付处理中
     */
    PROCESSING_PAYMENT("PROCESSINGPAYMENT", false),

    /**
     * 确认中
     */
    CONFIRMING_ALLOTMENT("CONFIRMINGALLOTMENT", false),

    /**
     * 大系统，确认中
     */
    CONFIRMING("CONFIRMING", false),

    /**
     * 已确认
     */
    CONFIRMED("CONFIRMED", false),
    /**
     * 没有提交，但支付了
     */
    SUBMITFAILEDPAID("SUBMITFAILEDPAID", false),

    /**
     * 没有提交，退款了
     */
    SUBMITFAILEDREFUND("SUBMITFAILEDREFUND", true),

    /**
     * 已取消
     */
    CANCELED("CANCELED", true),

    /**
     * 满房
     */
    NOROOM("NOROOM", false),

    FAILED("FAILED", true),

    /**
     * 已完成
     */
    FINISHED("FINISHED", true);

    SCOrderStatus(String status, boolean isFinal) {
        this(status, isFinal, status);
    }


    SCOrderStatus(String status, boolean isFinal, String description) {
        this.status = status;
        this.isFinal = isFinal;
        this.description = description;
    }

    /**
     * 订单状态
     */
    private String status;

    /**
     * 是否是最终状态. {@code true} 最终状态, {@code false} 不是最终状态
     *
     * 最终状态: 订单状态不会变化
     */
    private boolean isFinal;

    /**
     * 订单描述
     */
    private String description;

    public String getStatus() {
        return status;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public String getDescription() {
        return description;
    }
}