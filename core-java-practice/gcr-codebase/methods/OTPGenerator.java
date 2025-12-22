class OTPGenerator { // class to generate OTPs

    // generate 6 digit otp
    static int generateOTP() {

        // random gives decimal so converting
        return 100000 + (int)(Math.random() * 900000);
    }

    // checking all otp are unique or not
    
    static boolean isUnique(int[] otp) {
// nested loop to compare each otp
        for (int i = 0; i < otp.length; i++) {
            for (int j = i + 1; j < otp.length; j++) {

                if (otp[i] == otp[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] otpList = new int[10];

        // generating otp 10 times
        for (int i = 0; i < otpList.length; i++) {
            otpList[i] = generateOTP();
            System.out.println("OTP: " + otpList[i]);
        }

        // checking uniqueness

        System.out.println("All OTP unique: " + isUnique(otpList));
    }
}
// end of class OTPGenerator