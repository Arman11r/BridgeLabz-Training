public class profitloss {
    public static void main(String[] args) {
        double cp = 129; // Cost Price
        double sp = 191; // Selling Price
        if (sp > cp) {
            double profit = sp - cp;
           
        } else if (cp > sp) {
            double loss = cp - sp;
            
        } else {
            
        }
        //using single print statement to display multiline text and variables i.e profit and loss in value and percentage

        System.out.println("Cost Price: " + cp + ", Selling Price: " + sp + ", Profit Percentage: " + ((sp - cp) / cp) * 100 + "%, Loss Percentage: " + ((cp - sp) / cp) * 100 + "%");

    }
}
