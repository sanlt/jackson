package ch.bfh.http;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.json.JSONObject;

import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonClient {

    public static void main(String[] args) throws IOException {

        final String URL_BASE = "http://localhost:8080/";

        String search = "";
        Scanner scanner = new Scanner(System.in);


        do {

            System.out.print("Enter your search argument: ");
            search = scanner.nextLine();

            if (search.length() > 0) {
                URL url = new URL("http://localhost:8080/people/" + search);
                URLConnection yc = url.openConnection();
                // BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

               /* String line = "";
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }

                */

                List<String> persons = new ArrayList<>();

                JsonFactory factory = new JsonFactory();
                JsonParser parser = factory.createParser(yc.getInputStream());
                JsonToken token;
                token = parser.nextToken();

                while (token != JsonToken.END_ARRAY) {
                    token = parser.nextToken();
                    if (token == JsonToken.VALUE_STRING && "id".equals(parser.getCurrentName())) {
                        // System.out.println("ID : " + parser.getText());
                        persons.add("ID: ,,,,,,,,,,," );
                        persons.add(parser.getText());persons.add("\n");
                    }
                    if (token == JsonToken.VALUE_STRING && "name".equals(parser.getCurrentName())) {
                        // System.out.println("Last Name : " + parser.getText());
                        persons.add("Name: ");
                        persons.add(parser.getText());
                        persons.add("\n");
                    }
                    if (token == JsonToken.VALUE_STRING && "firstName".equals(parser.getCurrentName())) {
                        // System.out.println("First Name : " + parser.getText());
                        persons.add("First Name: ");
                        persons.add(parser.getText());
                        persons.add("\n");
                    }
                    if (token == JsonToken.VALUE_STRING && "zip".equals(parser.getCurrentName())) {
                        // System.out.println("ZIP : " + parser.getText());
                        persons.add("ZIP: ");
                        persons.add(parser.getText());
                        persons.add("\n");
                    }
                    if (token == JsonToken.VALUE_STRING && "city".equals(parser.getCurrentName())) {
                        // System.out.println("City : " + parser.getText());
                        persons.add("City: ");
                        persons.add(parser.getText());
                        persons.add("\n");
                    }
                }
                String formattedString = persons.toString()
                    .replace(",", "")  //remove the commas
                    .trim();
                System.out.println(formattedString);
            }


            // TODO: Contact your Json Server, read the
            //       returned results and translate the
            //       result into java objects and arrays.
            //       Show the results as a list in the
            //       console.


        } while (search.length() > 0);

        scanner.close();

    }

}
