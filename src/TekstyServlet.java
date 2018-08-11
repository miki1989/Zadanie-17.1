import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

@WebServlet(value = "/teksty")
public class TekstyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();


        String advanced = request.getParameter("advanced");
        writer.print("<br><b>" + advanced + "</b></br>");
        writer.print("<br><h3> Ilość znaków w tekście: " +advanced.length() + "</h3></br>"); //ilość wszystkich znaków

        int sumOfCharactersWithoutSpaces = 0;

        String[] withoutSpaces = advanced.split(" "); //znaki bez spacji
        for (int i = 0; i < withoutSpaces.length; i++) {
            int charWithoutSpaces = withoutSpaces[i].length();
            sumOfCharactersWithoutSpaces += charWithoutSpaces;
        }
        writer.print("<h3>Ilość znaków bez spacji: " + sumOfCharactersWithoutSpaces + "</h3><br>");

        List<String> words = new ArrayList<>();
        for (int i = 0; i < withoutSpaces.length; i++) {
            if (withoutSpaces[i].length() >= 2) {
                words.add(withoutSpaces[i]);
            }
        }
        writer.print("<h3>Ilośc wyrazów w tekście: " + words.size() + "</h3><br>"); // drukowanie ilości wyrazów w tekście

        String reverse = " ";
        List<String> palindroma = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(advanced, ",.!?-/; ");
        while (stringTokenizer.hasMoreTokens()) {
            String keytoPalindromes = stringTokenizer.nextToken();
            palindroma.add(keytoPalindromes);
        }

        //sprawdzanie czy jest palindroma
        String proba = String.join("",palindroma);
        String proba1 = proba.toLowerCase();
        String reverse1 = new StringBuffer(proba1).reverse().toString();
        String reversal = reverse1.toLowerCase();
        if (proba1.equals(reversal)){
            writer.print("<h3><b>Podany tekst palindromą<b></h3>");
        }
        else {
            writer.print("<h3><b>To nie jest palindroma<b></h3>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        String advanced = request.getParameter("advanced");
        writer.print(advanced);

    }
}

