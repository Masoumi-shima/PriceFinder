public class ProductDetails
{
    public String id;
    public String productNumber;
    public int quantity;
    public double unitPrice;
    public double totalPrice;

    public ProductDetails(String line)
    {
        String[] parts = line.split("\t");
        id = parts[0];
        productNumber = parts[1];
        quantity = Integer.parseInt(parts[2]);
        unitPrice = Double.parseDouble(parts[3]);
        totalPrice = Double.parseDouble(parts[4]);
    }
}
