//create a custom exception and create a demo data

class CustomException {
    public static void main(String[] args) {
        try {
            throw new PaymentFailedException("error is comming here!!");
        } catch (PaymentFailedException e) {
            System.out.println("Custom Exception:  " + e.getMessage() ) ;
        }
    }

    
}

class PaymentFailedException extends Exception {
    public PaymentFailedException ( String message ){
        super (message) ; 
    }
}


