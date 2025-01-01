package LabWeek13;

interface Payment{
    void processPayment();
}

interface PaymentFactory {
    Payment createPayment(String type);
}

class CreditCardPayment implements Payment{
    @Override
    public void processPayment(){
        System.out.println("Processing payment through Credit Card.");
    }
}

class PayPalPayment implements Payment{
    @Override
    public void processPayment(){
        System.out.println("Processing payment through PayPal.");
    }
}

class ConcretePaymentFactory implements PaymentFactory{
    public Payment createPayment(String type){
        if(type.equals("creditcard")){
            return new CreditCardPayment();
        }
        else if(type.equals("paypal")){
            return new PayPalPayment();
        }
        return null;
    }
}

class PaymentTask{
    public static void main(String[] args) {

        PaymentFactory paymentFactory = new ConcretePaymentFactory();

        Payment creditCardPayment = paymentFactory.createPayment("creditcard");
        creditCardPayment.processPayment();

        Payment paypalPayment = paymentFactory.createPayment("paypal");
        paypalPayment.processPayment();
    }
}
