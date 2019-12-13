package com.okhttp.okhttputils;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 创建时间：2019/11/15
 * <p>
 * 作者：Mr.Liu
 * <p>
 * 描述：新接口的productbean
 **/
public class HomeProdctB implements Serializable {

    /**
     * status : 200
     * message : success
     * data : {"companyInfo":{"contactMobile":"+63123456789","appDescription":"Samset Vay là một ứng dụng cho vay trực tuyến ởViệt Nam với số lượng tiền vay từ 1-10 triệu vnd. Chúng tôi đã đơn giản hóa dịch vụ cho vay tại Việt Nam và bạn chỉ cần một CMND để nộp đơn,nhanh chóng và dễ dàng.\n●\tLỢI THẾVAY TIỀN TỪ VN VAY:\n✔\tThủ tục cho vay rất đơn giản:Chỉ với CMND\n✔\tTỉ lệ giải ngân và sắc xuất thông qua cao\n✔\tDuyệt hồ sơ nhanh: Chỉ từ 5 phút\n●\tĐẶC ĐIỂM CỦA VNVAY:\n✔\tThời hạn vay: 180 ngày\n✔\tCho vay Ngắn hạn\n✔\tHạn mức vay linh hoạt:1-10 triệu vnd\n✔\tĐộ bảo mật cao: Chúng tôi giữ quyền riêng tư của người dùng và sẽ không cung cấp thông tin cá nhân của bạn cho bên thứ ba mà không có sự đồng ý của bạn.\n●\tYÊU CẦU:\n-Công dân Việt Nam từ 18 tuổi.\n-Chỉ cần có CMND và số điện thoại hợp lệ\n- Người có thu nhập cố định\n- Thanh toán đúng hạn hoặc trước hạn được thông báo\n●\tQuy trình cho vay\n1. Tải ứng dụng\n2. Điền thông tin cá nhân của bạn\n3. Xác minh tính xác thực của thông tin\n4. Thanh toán\n●\tYêu cầu quyền ứng dụng:\n✔\tTruy cập vị trí - Tự động xác minh địa chỉ của bạn.\n✔\tLiên hệ - Thuận tiện chỉ định chi tiết liên lạc của bạn\n✔\tTruy cập máy ảnh - Quét CMND của bạn để xác minh danh tính bằng công nghệ nhận dạng khuôn mặt.\n\n✔ Tel: +84 0785397437    Email: vietamservice@weiyunshengshi.com\n\n✔ Address : 7/1 Thanh Thai Street, Ward 14,District 10 Ho Chi Minh, Ho Chi Minh City Vietnam\n\n●\tCopyright © 2019-2020   TREASURE BOWL FINACIAL SERVICES CO.,LTD"},"productDtoList":[{"duration":"180Ngày","amount":"\u20ab 2.000.000","id":1,"productName":"DEFAULT","canChoose":true},{"duration":"7Ngày","amount":"\u20ab 6.000.000","id":2,"productName":"PH_TEST","canChoose":true},{"duration":"7/14Ngày","amount":"\u20ab 7.000.000-\u20ab 8.000.000","id":3,"productName":"THRID_TEST","canChoose":true}],"latestLoanApp":null}
     */

    private int status;
    private String message;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * companyInfo : {"contactMobile":"+63123456789","appDescription":"Samset Vay là một ứng dụng cho vay trực tuyến ởViệt Nam với số lượng tiền vay từ 1-10 triệu vnd. Chúng tôi đã đơn giản hóa dịch vụ cho vay tại Việt Nam và bạn chỉ cần một CMND để nộp đơn,nhanh chóng và dễ dàng.\n●\tLỢI THẾVAY TIỀN TỪ VN VAY:\n✔\tThủ tục cho vay rất đơn giản:Chỉ với CMND\n✔\tTỉ lệ giải ngân và sắc xuất thông qua cao\n✔\tDuyệt hồ sơ nhanh: Chỉ từ 5 phút\n●\tĐẶC ĐIỂM CỦA VNVAY:\n✔\tThời hạn vay: 180 ngày\n✔\tCho vay Ngắn hạn\n✔\tHạn mức vay linh hoạt:1-10 triệu vnd\n✔\tĐộ bảo mật cao: Chúng tôi giữ quyền riêng tư của người dùng và sẽ không cung cấp thông tin cá nhân của bạn cho bên thứ ba mà không có sự đồng ý của bạn.\n●\tYÊU CẦU:\n-Công dân Việt Nam từ 18 tuổi.\n-Chỉ cần có CMND và số điện thoại hợp lệ\n- Người có thu nhập cố định\n- Thanh toán đúng hạn hoặc trước hạn được thông báo\n●\tQuy trình cho vay\n1. Tải ứng dụng\n2. Điền thông tin cá nhân của bạn\n3. Xác minh tính xác thực của thông tin\n4. Thanh toán\n●\tYêu cầu quyền ứng dụng:\n✔\tTruy cập vị trí - Tự động xác minh địa chỉ của bạn.\n✔\tLiên hệ - Thuận tiện chỉ định chi tiết liên lạc của bạn\n✔\tTruy cập máy ảnh - Quét CMND của bạn để xác minh danh tính bằng công nghệ nhận dạng khuôn mặt.\n\n✔ Tel: +84 0785397437    Email: vietamservice@weiyunshengshi.com\n\n✔ Address : 7/1 Thanh Thai Street, Ward 14,District 10 Ho Chi Minh, Ho Chi Minh City Vietnam\n\n●\tCopyright © 2019-2020   TREASURE BOWL FINACIAL SERVICES CO.,LTD"}
         * productDtoList : [{"duration":"180Ngày","amount":"\u20ab 2.000.000","id":1,"productName":"DEFAULT","canChoose":true},{"duration":"7Ngày","amount":"\u20ab 6.000.000","id":2,"productName":"PH_TEST","canChoose":true},{"duration":"7/14Ngày","amount":"\u20ab 7.000.000-\u20ab 8.000.000","id":3,"productName":"THRID_TEST","canChoose":true}]
         * latestLoanApp : null
         */

        private CompanyInfoBean companyInfo;
        private Object latestLoanApp;
        private List<ProductDtoListBean> productDtoList;

        public CompanyInfoBean getCompanyInfo() {
            return companyInfo;
        }

        public void setCompanyInfo(CompanyInfoBean companyInfo) {
            this.companyInfo = companyInfo;
        }

        public Object getLatestLoanApp() {
            return latestLoanApp;
        }

        public void setLatestLoanApp(Object latestLoanApp) {
            this.latestLoanApp = latestLoanApp;
        }

        public List<ProductDtoListBean> getProductDtoList() {
            return productDtoList;
        }

        public void setProductDtoList(List<ProductDtoListBean> productDtoList) {
            this.productDtoList = productDtoList;
        }

        public static class CompanyInfoBean implements Serializable{
            /**
             * contactMobile : +63123456789
             * appDescription : Samset Vay là một ứng dụng cho vay trực tuyến ởViệt Nam với số lượng tiền vay từ 1-10 triệu vnd. Chúng tôi đã đơn giản hóa dịch vụ cho vay tại Việt Nam và bạn chỉ cần một CMND để nộp đơn,nhanh chóng và dễ dàng.
             ●	LỢI THẾVAY TIỀN TỪ VN VAY:
             ✔	Thủ tục cho vay rất đơn giản:Chỉ với CMND
             ✔	Tỉ lệ giải ngân và sắc xuất thông qua cao
             ✔	Duyệt hồ sơ nhanh: Chỉ từ 5 phút
             ●	ĐẶC ĐIỂM CỦA VNVAY:
             ✔	Thời hạn vay: 180 ngày
             ✔	Cho vay Ngắn hạn
             ✔	Hạn mức vay linh hoạt:1-10 triệu vnd
             ✔	Độ bảo mật cao: Chúng tôi giữ quyền riêng tư của người dùng và sẽ không cung cấp thông tin cá nhân của bạn cho bên thứ ba mà không có sự đồng ý của bạn.
             ●	YÊU CẦU:
             -Công dân Việt Nam từ 18 tuổi.
             -Chỉ cần có CMND và số điện thoại hợp lệ
             - Người có thu nhập cố định
             - Thanh toán đúng hạn hoặc trước hạn được thông báo
             ●	Quy trình cho vay
             1. Tải ứng dụng
             2. Điền thông tin cá nhân của bạn
             3. Xác minh tính xác thực của thông tin
             4. Thanh toán
             ●	Yêu cầu quyền ứng dụng:
             ✔	Truy cập vị trí - Tự động xác minh địa chỉ của bạn.
             ✔	Liên hệ - Thuận tiện chỉ định chi tiết liên lạc của bạn
             ✔	Truy cập máy ảnh - Quét CMND của bạn để xác minh danh tính bằng công nghệ nhận dạng khuôn mặt.

             ✔ Tel: +84 0785397437    Email: vietamservice@weiyunshengshi.com

             ✔ Address : 7/1 Thanh Thai Street, Ward 14,District 10 Ho Chi Minh, Ho Chi Minh City Vietnam

             ●	Copyright © 2019-2020   TREASURE BOWL FINACIAL SERVICES CO.,LTD
             */

            private String contactMobile;
            private String appDescription;

            public String getContactMobile() {
                return contactMobile;
            }

            public void setContactMobile(String contactMobile) {
                this.contactMobile = contactMobile;
            }

            public String getAppDescription() {
                return appDescription;
            }

            public void setAppDescription(String appDescription) {
                this.appDescription = appDescription;
            }
        }

        public static class ProductDtoListBean implements Serializable{
            /**
             * duration : 180Ngày
             * amount : ₫ 2.000.000
             * id : 1
             * productName : DEFAULT
             * canChoose : true
             */

            private String duration;
            private String amount;
            private int id;
            private String productName;
            private boolean canChoose;

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public boolean isCanChoose() {
                return canChoose;
            }

            public void setCanChoose(boolean canChoose) {
                this.canChoose = canChoose;
            }
        }
    }
}
