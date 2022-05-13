import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PriceFinder
{
    private static final String FILE_PATH = "/Users/melpomene/PriceFinder/src/main/Facture/%s.txt";

    public static void main(String[] args)
    {
        ProductDetails productDetails = getClientFile(args[0]).stream()
                .filter(p -> p.productNumber.equals(args[1]))
                .findFirst()
                .get();
        System.out.println(String.format("Quantity : %s - Total : %s",
                productDetails.quantity, productDetails.totalPrice));


        //getClientFile(args[0]).forEach(System.out::println);
//        for (String s : getClientFile(args[0]).stream().filter(p -> p.startsWith("P")))
//        {
//            System.out.println(s);
//        }
    }

    private static List<ProductDetails> getClientFile(String client)
    {
        List<ProductDetails> lines = new ArrayList<>();
        try
        {
            File myObj = new File(String.format(FILE_PATH, client));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String line = myReader.nextLine();
                if (line.startsWith("P"))
                {
                    lines.add(new ProductDetails(line));
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return lines;
    }
}
