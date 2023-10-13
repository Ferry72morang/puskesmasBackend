package id.puskesmas.backend.util;


public class ErrorResponse {
    String status;
    String message;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public ErrorResponse() {
    }

    @SuppressWarnings("all")
    public String getStatus() {
        return this.status;
    }

    @SuppressWarnings("all")
    public String getMessage() {
        return this.message;
    }

    @SuppressWarnings("all")
    public void setStatus(final String status) {
        this.status = status;
    }

    @SuppressWarnings("all")
    public void setMessage(final String message) {
        this.message = message;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ErrorResponse)) return false;
        final ErrorResponse other = (ErrorResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof ErrorResponse;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "ErrorResponse(status=" + this.getStatus() + ", message=" + this.getMessage() + ")";
    }
    //</editor-fold>
}
