import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;

public class Test {


    public static void main(String[] args) throws java.io.IOException {
        String vehicleID = null;
        String postEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator";
        String inputJson = "{\n" +
                "    \"nickName\": \"Blinky\",\n" +
                "    \"make\": \"F\",\n" +
                "    \"modelName\": \"F-150\",\n" +
                "    \"modelYear\": \"2017\",\n" +
                "    \"color\": \"ANT BLU MET\",\n" +
                "    \"engineType\": \"ICE\",\n" +
                "    \"imageName\": \"ford_2017_f150_rubyredtc_raptor\",\n" +
                "    \"imageUrl\": \"http://localhost:8080/api/fordconnect/images/vehicles/full_ford_2017_f150_rubyredtc_raptor.png\",\n" +
                "    \"doors\": [\n" +
                "        {\n" +
                "            \"type\":\"UNSPECIFIED_FRONT\",\n" +
                "            \"role\":\"DRIVER\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\":\"UNSPECIFIED_FRONT\",\n" +
                "            \"role\":\"PASSENGER\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\":\"HOOD_DOOR\",\n" +
                "            \"role\":\"NOT_APPLICABLE\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\":\"REAR_LEFT\",\n" +
                "            \"role\":\"PASSENGER\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\":\"REAR_RIGHT\",\n" +
                "            \"role\":\"PASSENGER\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\":\"TAILGATE\",\n" +
                "            \"role\":\"PASSENGER\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\":\"INNER_TAILGATE\",\n" +
                "            \"role\":\"PASSENGER\"\n" +
                "        }\n" +
                "    ],\n" +
                "     \"fuelLevel\": {\n" +
                "            \"percentage\": 100.0,\n" +
                "            \"distanceToEmptyKm\": 380.0\n" +
                "        },\n" +
                "     \"batteryChargeLevel\": {\n" +
                "            \"percentage\": 100.0,\n" +
                "            \"distanceToEmptyKm\": 380.0\n" +
                "        }\n" +
                "}\n" +
                "\n";
        System.out.println(inputJson);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            String respBdy = response.body();
            System.out.println(response.body());
            String[] arrOfStr = respBdy.split("\\{");
            String arr1 = arrOfStr[1];
            String[] arrOfStr1 = arr1.split("}");

            String arr2 = arrOfStr1[0];
            String[] arrOfStr2 = arr2.split(",");
            String arr3 = arrOfStr2[1];
            String[] arrOfStr3 = arr3.split("\"");
            vehicleID = arrOfStr3[3];
        }
        catch(Exception e) {
            //  Block of code to handle errors
        }


        Test t = new Test();
        t.runTestNormPressure(vehicleID);
        t.runTestHighPressure(vehicleID);
        t.runTestLowFuelConsumption(vehicleID);
        t.runTestLowPressure(vehicleID);
        t.runTestHighFuelConsumption(vehicleID);
        t.runTestNormFuelConsumption(vehicleID);
        t.runTestNormBatteryConsumption(vehicleID);
        t.testBatteryOverCharge(vehicleID);
        t.testBatteryUnderCharge(vehicleID);
//        t.testCanStartCar(vehicleID);
//        t.testCannotStartCar(vehicleID);
//        t.testCanCharge(vehicleID);
//        t.testCannotCharge(vehicleID);

        postEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicleID;
       inputJson = null;
//        System.out.println(inputJson);
        request = HttpRequest.newBuilder()
                .uri(URI.create(postEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .DELETE()
                .build();
        client = HttpClient.newHttpClient();
        try {
            System.out.println(request);
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            String respBdy = response.body();
            System.out.println(response.body());

        }
        catch(Exception e) {
            //  Block of code to handle errors
        }
    }

    public void runTestNormFuelConsumption(String vehicle) {
        int startHours = 0;
        int startMinutes = 0;
        int startSeconds = 0;
        int endHours = 0;
        int endMinutes = 0;
        int endSeconds = 0;
        double endFuel = 0;
        String inputJson = "{\n}";
        String putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        HttpClient client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            startHours = Integer.parseInt(timeParams[0]);
            startMinutes = Integer.parseInt(timeParams[1]);
            startSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        double fuel = 0.00;
        double percentage = 0.00;
        for (int i = 1; i < 11; i++) {
            int fuelPercentage = 90 + i;
            double distToEmptKm = 342 + (3.8 * i);
            inputJson = "{\n" +
                    "    \"percentage\": "+ fuelPercentage +",\n" +
                    "    \"distanceToEmptyKm\": "+ distToEmptKm +
                    "}";
            putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
            System.out.println(vehicle + " " + putEndpoint);
            request2 = HttpRequest.newBuilder()
                    .uri(URI.create(putEndpoint))
                    .header("Content-Type", "application/json")
                    .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                    .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                    .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();
            client2 = HttpClient.newHttpClient();
            try {
                HttpResponse<String> response = client2.send(request2,
                        HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                String respBdy = response.body();
                String[] arrOfStr = respBdy.split("\\{");
                String arr1 = arrOfStr[2];
                String[] arrOfStr1 = arr1.split(":");
                String arr2 = arrOfStr1[1];
                String arr3 = arrOfStr1[2];

                String[] arrOfStr2 = arr2.split(",");
                String[] arrOfStr3 = arr3.split("}}");
                String arr4 = arrOfStr2[0];
                String arr5 = arrOfStr3[0];
                fuel = Double.parseDouble(arr5);
                percentage = Double.parseDouble(arr4);
            } catch (Exception e) {
                //  Block of code to handle errors
            }
        }



        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            endHours = Integer.parseInt(timeParams[0]);
            endMinutes = Integer.parseInt(timeParams[1]);
            endSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startTime = (startHours * 60 * 60) + (startMinutes * 60) + startSeconds;
        int endTime = (endHours * 60 * 60) + (endMinutes * 60) + endSeconds;
        Main m = new Main();
        System.out.println(m.getAvgPressure(startTime, endTime, 100.0, percentage));
        System.out.println(m.getAvgFuel(startTime, endTime, 10.0, percentage/38));
    }
    public void runTestLowPressure(String vehicle){
        String inputJson = "{\"clockSpeed\": 0.4}";
        String putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        HttpClient client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startHours = 0;
        int startMinutes = 0;
        int startSeconds = 0;
        int endHours = 0;
        int endMinutes = 0;
        int endSeconds = 0;
        double endFuel = 0;
        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            startHours = Integer.parseInt(timeParams[0]);
            startMinutes = Integer.parseInt(timeParams[1]);
            startSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        double fuel = 0.00;
        double percentage = 0.00;
        for (int i = 1; i < 21; i++) {
            int fuelPercentage = 100 - i;
            double distToEmptKm = 380 - (3.8 * i);
            inputJson = "{\n" +
                    "    \"percentage\": "+ fuelPercentage +",\n" +
                    "    \"distanceToEmptyKm\": "+ distToEmptKm +
                    "}";
            putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
            System.out.println(vehicle + " " + putEndpoint);
            request2 = HttpRequest.newBuilder()
                    .uri(URI.create(putEndpoint))
                    .header("Content-Type", "application/json")
                    .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                    .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                    .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();
            client2 = HttpClient.newHttpClient();
            try {
                HttpResponse<String> response = client2.send(request2,
                        HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                String respBdy = response.body();
                String[] arrOfStr = respBdy.split("\\{");
                String arr1 = arrOfStr[2];
                String[] arrOfStr1 = arr1.split(":");
                String arr2 = arrOfStr1[1];
                String arr3 = arrOfStr1[2];

                String[] arrOfStr2 = arr2.split(",");
                String[] arrOfStr3 = arr3.split("}}");
                String arr4 = arrOfStr2[0];
                String arr5 = arrOfStr3[0];
                fuel = Double.parseDouble(arr5);
                percentage = Double.parseDouble(arr4);
            } catch (Exception e) {
                //  Block of code to handle errors
            }
        }



        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            endHours = Integer.parseInt(timeParams[0]);
            endMinutes = Integer.parseInt(timeParams[1]);
            endSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startTime = (startHours * 60 * 60) + (startMinutes * 60) + startSeconds;
        int endTime = (endHours * 60 * 60) + (endMinutes * 60) + endSeconds;
        Main m = new Main();
        System.out.println(m.getAvgPressure(startTime, endTime, 100.0, percentage));
        System.out.println(m.getAvgFuel(startTime, endTime, 10.0, percentage/38));
    }
    public void testBatteryUnderCharge(String vehicle){
        String inputJson = "{\"clockSpeed\": 60.0}";
        String putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        HttpClient client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 90.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/battery";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startHours = 0;
        int startMinutes = 0;
        int startSeconds = 0;
        int endHours = 0;
        int endMinutes = 0;
        int endSeconds = 0;
        double endFuel = 0;
        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            startHours = Integer.parseInt(timeParams[0]);
            startMinutes = Integer.parseInt(timeParams[1]);
            startSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        double fuel = 0.00;
        double percentage = 0.00;
        for (int i = 1; i < 11; i++) {
            int fuelPercentage = 90 + i;
            double distToEmptKm = 342 + (3.8 * i);
            inputJson = "{\n" +
                    "    \"percentage\": "+ fuelPercentage +",\n" +
                    "    \"distanceToEmptyKm\": "+ distToEmptKm +
                    "}";
            putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/battery";
            System.out.println(vehicle + " " + putEndpoint);
            request2 = HttpRequest.newBuilder()
                    .uri(URI.create(putEndpoint))
                    .header("Content-Type", "application/json")
                    .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                    .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                    .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();
            client2 = HttpClient.newHttpClient();
            try {
                HttpResponse<String> response = client2.send(request2,
                        HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                String respBdy = response.body();
                String[] arrOfStr = respBdy.split("\\{");
                String arr1 = arrOfStr[2];
                String[] arrOfStr1 = arr1.split(":");
                String arr2 = arrOfStr1[1];
                String arr3 = arrOfStr1[2];

                String[] arrOfStr2 = arr2.split(",");
                String[] arrOfStr3 = arr3.split("}}");
                String arr4 = arrOfStr2[0];
                String arr5 = arrOfStr3[0];
                fuel = Double.parseDouble(arr5);
                percentage = Double.parseDouble(arr4);
            } catch (Exception e) {
                //  Block of code to handle errors
            }
        }



        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            endHours = Integer.parseInt(timeParams[0]);
            endMinutes = Integer.parseInt(timeParams[1]);
            endSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/battery";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startTime = (startHours * 60 * 60) + (startMinutes * 60) + startSeconds;
        int endTime = (endHours * 60 * 60) + (endMinutes * 60) + endSeconds;
        Main m = new Main();
        System.out.println(m.getAvgPressure(startTime, endTime, 100.0, percentage));
//        System.out.println(m.getAvgFuel(startTime, endTime, 10.0, percentage/38));
    }
    public void testBatteryOverCharge(String vehicle){
        String inputJson = "{\"clockSpeed\": 0.4}";
        String putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        HttpClient client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 90.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/battery";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startHours = 0;
        int startMinutes = 0;
        int startSeconds = 0;
        int endHours = 0;
        int endMinutes = 0;
        int endSeconds = 0;
        double endFuel = 0;
        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            startHours = Integer.parseInt(timeParams[0]);
            startMinutes = Integer.parseInt(timeParams[1]);
            startSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        double fuel = 0.00;
        double percentage = 0.00;
        for (int i = 1; i < 11; i++) {
            int fuelPercentage = 90 + i;
            double distToEmptKm = 342 + (3.8 * i);
            inputJson = "{\n" +
                    "    \"percentage\": "+ fuelPercentage +",\n" +
                    "    \"distanceToEmptyKm\": "+ distToEmptKm +
                    "}";
            putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/battery";
            System.out.println(vehicle + " " + putEndpoint);
            request2 = HttpRequest.newBuilder()
                    .uri(URI.create(putEndpoint))
                    .header("Content-Type", "application/json")
                    .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                    .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                    .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();
            client2 = HttpClient.newHttpClient();
            try {
                HttpResponse<String> response = client2.send(request2,
                        HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                String respBdy = response.body();
                String[] arrOfStr = respBdy.split("\\{");
                String arr1 = arrOfStr[2];
                String[] arrOfStr1 = arr1.split(":");
                String arr2 = arrOfStr1[1];
                String arr3 = arrOfStr1[2];

                String[] arrOfStr2 = arr2.split(",");
                String[] arrOfStr3 = arr3.split("}}");
                String arr4 = arrOfStr2[0];
                String arr5 = arrOfStr3[0];
                fuel = Double.parseDouble(arr5);
                percentage = Double.parseDouble(arr4);
            } catch (Exception e) {
                //  Block of code to handle errors
            }
        }



        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            endHours = Integer.parseInt(timeParams[0]);
            endMinutes = Integer.parseInt(timeParams[1]);
            endSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/battery";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startTime = (startHours * 60 * 60) + (startMinutes * 60) + startSeconds;
        int endTime = (endHours * 60 * 60) + (endMinutes * 60) + endSeconds;
        Main m = new Main();
        System.out.println(m.getAvgPressure(startTime, endTime, 90.0, percentage));
//        System.out.println(m.getAvgFuel(startTime, endTime, 10.0, percentage/38));
    }
    public void runTestNormBatteryConsumption(String vehicle) {
        int startHours = 0;
        int startMinutes = 0;
        int startSeconds = 0;
        int endHours = 0;
        int endMinutes = 0;
        int endSeconds = 0;
        double endFuel = 0;
        String inputJson = "{\n}";
        String putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        HttpClient client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            startHours = Integer.parseInt(timeParams[0]);
            startMinutes = Integer.parseInt(timeParams[1]);
            startSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        double fuel = 0.00;
        double percentage = 0.00;
        for (int i = 1; i < 11; i++) {
            int fuelPercentage = 90 + i;
            double distToEmptKm = 342 + (3.8 * i);
            inputJson = "{\n" +
                    "    \"percentage\": "+ fuelPercentage +",\n" +
                    "    \"distanceToEmptyKm\": "+ distToEmptKm +
                    "}";
            putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/battery";
            System.out.println(vehicle + " " + putEndpoint);
            request2 = HttpRequest.newBuilder()
                    .uri(URI.create(putEndpoint))
                    .header("Content-Type", "application/json")
                    .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                    .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                    .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();
            client2 = HttpClient.newHttpClient();
            try {
                HttpResponse<String> response = client2.send(request2,
                        HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                String respBdy = response.body();
                String[] arrOfStr = respBdy.split("\\{");
                String arr1 = arrOfStr[2];
                String[] arrOfStr1 = arr1.split(":");
                String arr2 = arrOfStr1[1];
                String arr3 = arrOfStr1[2];

                String[] arrOfStr2 = arr2.split(",");
                String[] arrOfStr3 = arr3.split("}}");
                String arr4 = arrOfStr2[0];
                String arr5 = arrOfStr3[0];
                fuel = Double.parseDouble(arr5);
                percentage = Double.parseDouble(arr4);
            } catch (Exception e) {
                //  Block of code to handle errors
            }
        }



        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            endHours = Integer.parseInt(timeParams[0]);
            endMinutes = Integer.parseInt(timeParams[1]);
            endSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/battery";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startTime = (startHours * 60 * 60) + (startMinutes * 60) + startSeconds;
        int endTime = (endHours * 60 * 60) + (endMinutes * 60) + endSeconds;
        Main m = new Main();
        System.out.println(m.getAvgPressure(startTime, endTime, 90.0, percentage));
//        System.out.println(m.getAvgFuel(startTime, endTime, 10.0, percentage/38));
    }
    public void runTestNormPressure(String vehicle) {
        int startHours = 0;
        int startMinutes = 0;
        int startSeconds = 0;
        int endHours = 0;
        int endMinutes = 0;
        int endSeconds = 0;
        double endFuel = 0;
        String inputJson = "{\n}";
        String putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        HttpClient client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            startHours = Integer.parseInt(timeParams[0]);
            startMinutes = Integer.parseInt(timeParams[1]);
            startSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        double fuel = 0.00;
        double percentage = 0.00;
        for (int i = 1; i < 11; i++) {
            int fuelPercentage = 100 - i;
            double distToEmptKm = 380 - (3.8 * i);
            inputJson = "{\n" +
                    "    \"percentage\": "+ fuelPercentage +",\n" +
                    "    \"distanceToEmptyKm\": "+ distToEmptKm +
                    "}";
            putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
            System.out.println(vehicle + " " + putEndpoint);
            request2 = HttpRequest.newBuilder()
                    .uri(URI.create(putEndpoint))
                    .header("Content-Type", "application/json")
                    .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                    .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                    .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();
            client2 = HttpClient.newHttpClient();
            try {
                HttpResponse<String> response = client2.send(request2,
                        HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                String respBdy = response.body();
                String[] arrOfStr = respBdy.split("\\{");
                String arr1 = arrOfStr[2];
                String[] arrOfStr1 = arr1.split(":");
                String arr2 = arrOfStr1[1];
                String arr3 = arrOfStr1[2];

                String[] arrOfStr2 = arr2.split(",");
                String[] arrOfStr3 = arr3.split("}}");
                String arr4 = arrOfStr2[0];
                String arr5 = arrOfStr3[0];
                fuel = Double.parseDouble(arr5);
                percentage = Double.parseDouble(arr4);
            } catch (Exception e) {
                //  Block of code to handle errors
            }
        }



        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            endHours = Integer.parseInt(timeParams[0]);
            endMinutes = Integer.parseInt(timeParams[1]);
            endSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startTime = (startHours * 60 * 60) + (startMinutes * 60) + startSeconds;
        int endTime = (endHours * 60 * 60) + (endMinutes * 60) + endSeconds;
        Main m = new Main();
        System.out.println(m.getAvgPressure(startTime, endTime, 100.0, percentage));
        System.out.println(m.getAvgFuel(startTime, endTime, 10.0, percentage/38));
    }
    public void runTestHighPressure(String vehicle){
        String inputJson = "{\"clockSpeed\": 60.0}";
        String putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        HttpClient client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startHours = 0;
        int startMinutes = 0;
        int startSeconds = 0;
        int endHours = 0;
        int endMinutes = 0;
        int endSeconds = 0;
        double endFuel = 0;
        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            startHours = Integer.parseInt(timeParams[0]);
            startMinutes = Integer.parseInt(timeParams[1]);
            startSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        double fuel = 0.00;
        double percentage = 0.00;
        for (int i = 1; i < 11; i++) {
            int fuelPercentage = 100 - i;
            double distToEmptKm = 380 - (3.8 * i);
            inputJson = "{\n" +
                    "    \"percentage\": "+ fuelPercentage +",\n" +
                    "    \"distanceToEmptyKm\": "+ distToEmptKm +
                    "}";
            putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
            System.out.println(vehicle + " " + putEndpoint);
            request2 = HttpRequest.newBuilder()
                    .uri(URI.create(putEndpoint))
                    .header("Content-Type", "application/json")
                    .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                    .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                    .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();
            client2 = HttpClient.newHttpClient();
            try {
                HttpResponse<String> response = client2.send(request2,
                        HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                String respBdy = response.body();
                String[] arrOfStr = respBdy.split("\\{");
                String arr1 = arrOfStr[2];
                String[] arrOfStr1 = arr1.split(":");
                String arr2 = arrOfStr1[1];
                String arr3 = arrOfStr1[2];

                String[] arrOfStr2 = arr2.split(",");
                String[] arrOfStr3 = arr3.split("}}");
                String arr4 = arrOfStr2[0];
                String arr5 = arrOfStr3[0];
                fuel = Double.parseDouble(arr5);
                percentage = Double.parseDouble(arr4);
            } catch (Exception e) {
                //  Block of code to handle errors
            }
        }



        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            endHours = Integer.parseInt(timeParams[0]);
            endMinutes = Integer.parseInt(timeParams[1]);
            endSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startTime = (startHours * 60 * 60) + (startMinutes * 60) + startSeconds;
        int endTime = (endHours * 60 * 60) + (endMinutes * 60) + endSeconds;
        Main m = new Main();
        System.out.println(m.getAvgPressure(startTime, endTime, 100.0, percentage));
        System.out.println(m.getAvgFuel(startTime, endTime, 10.0, percentage/38));
    }
    public void runTestLowFuelConsumption(String vehicle){
        String inputJson = "{\"clockSpeed\": 0.4}";
        String putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        HttpClient client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startHours = 0;
        int startMinutes = 0;
        int startSeconds = 0;
        int endHours = 0;
        int endMinutes = 0;
        int endSeconds = 0;
        double endFuel = 0;
        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            startHours = Integer.parseInt(timeParams[0]);
            startMinutes = Integer.parseInt(timeParams[1]);
            startSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        double fuel = 0.00;
        double percentage = 0.00;
        for (int i = 1; i < 21; i++) {
            int fuelPercentage = 100 - i;
            double distToEmptKm = 380 - (3.8 * i);
            inputJson = "{\n" +
                    "    \"percentage\": "+ fuelPercentage +",\n" +
                    "    \"distanceToEmptyKm\": "+ distToEmptKm +
                    "}";
            putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
            System.out.println(vehicle + " " + putEndpoint);
            request2 = HttpRequest.newBuilder()
                    .uri(URI.create(putEndpoint))
                    .header("Content-Type", "application/json")
                    .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                    .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                    .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();
            client2 = HttpClient.newHttpClient();
            try {
                HttpResponse<String> response = client2.send(request2,
                        HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                String respBdy = response.body();
                String[] arrOfStr = respBdy.split("\\{");
                String arr1 = arrOfStr[2];
                String[] arrOfStr1 = arr1.split(":");
                String arr2 = arrOfStr1[1];
                String arr3 = arrOfStr1[2];

                String[] arrOfStr2 = arr2.split(",");
                String[] arrOfStr3 = arr3.split("}}");
                String arr4 = arrOfStr2[0];
                String arr5 = arrOfStr3[0];
                fuel = Double.parseDouble(arr5);
                percentage = Double.parseDouble(arr4);
            } catch (Exception e) {
                //  Block of code to handle errors
            }
        }



        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            endHours = Integer.parseInt(timeParams[0]);
            endMinutes = Integer.parseInt(timeParams[1]);
            endSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startTime = (startHours * 60 * 60) + (startMinutes * 60) + startSeconds;
        int endTime = (endHours * 60 * 60) + (endMinutes * 60) + endSeconds;
        Main m = new Main();
        System.out.println(m.getAvgPressure(startTime, endTime, 100.0, percentage));
        System.out.println(m.getAvgFuel(startTime, endTime, 10.0, percentage/38));
    }
    public void runTestHighFuelConsumption(String vehicle){
        String inputJson = "{\"clockSpeed\": 60.0}";
        String putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        HttpClient client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startHours = 0;
        int startMinutes = 0;
        int startSeconds = 0;
        int endHours = 0;
        int endMinutes = 0;
        int endSeconds = 0;
        double endFuel = 0;
        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            startHours = Integer.parseInt(timeParams[0]);
            startMinutes = Integer.parseInt(timeParams[1]);
            startSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        double fuel = 0.00;
        double percentage = 0.00;
        for (int i = 1; i < 11; i++) {
            int fuelPercentage = 100 - i;
            double distToEmptKm = 380 - (3.8 * i);
            inputJson = "{\n" +
                    "    \"percentage\": "+ fuelPercentage +",\n" +
                    "    \"distanceToEmptyKm\": "+ distToEmptKm +
                    "}";
            putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
            System.out.println(vehicle + " " + putEndpoint);
            request2 = HttpRequest.newBuilder()
                    .uri(URI.create(putEndpoint))
                    .header("Content-Type", "application/json")
                    .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                    .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                    .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                    .build();
            client2 = HttpClient.newHttpClient();
            try {
                HttpResponse<String> response = client2.send(request2,
                        HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                String respBdy = response.body();
                String[] arrOfStr = respBdy.split("\\{");
                String arr1 = arrOfStr[2];
                String[] arrOfStr1 = arr1.split(":");
                String arr2 = arrOfStr1[1];
                String arr3 = arrOfStr1[2];

                String[] arrOfStr2 = arr2.split(",");
                String[] arrOfStr3 = arr3.split("}}");
                String arr4 = arrOfStr2[0];
                String arr5 = arrOfStr3[0];
                fuel = Double.parseDouble(arr5);
                percentage = Double.parseDouble(arr4);
            } catch (Exception e) {
                //  Block of code to handle errors
            }
        }



        inputJson = "{\n}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/clock";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String body = response.body();
            String[] bodySplit = body.split(",");
            String[] dateTime = bodySplit[2].split("\"");
            String[] time = dateTime[3].split(" ");
            String[] timeParams = time[1].split(":");
            endHours = Integer.parseInt(timeParams[0]);
            endMinutes = Integer.parseInt(timeParams[1]);
            endSeconds = Integer.parseInt(timeParams[2]);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
        inputJson = "{\n" +
                "    \"percentage\": 100.0,\n" +
                "    \"distanceToEmptyKm\": 380.0}";
        putEndpoint = "https://fcon-simulatedvehicle.apps.pd01e.edc1.cf.ford.com/api/fordconnect/v1/simulator/" + vehicle + "/fuel";
        System.out.println(vehicle + " " + putEndpoint);
        request2 = HttpRequest.newBuilder()
                .uri(URI.create(putEndpoint))
                .header("Content-Type", "application/json")
                .header("Application-Id", "afdc085b-377a-4351-b23e-5e1d35fb3700")
                .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleS0xIiwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldUIn0iwidHlwIjoiSldg.eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9eyJhenAiOiJBWlAiLCJtdG1JZCI6Im10bUlkIiwic2NwIjoic2NwIiwidXNlckd1aWQiOiJlbmNvZGVkLWd1aWQtdmFsdWUuLiJ9.mSHjHPoduQ2UG4mv5jMj9LeVdbmCG7lTYvzFeUKDUgaArdBFwH2gvjPELgUYU1_Hmx90yS3A3YykGDqEI-c1v0d717wLQzhce8q_G5cqIgLKiIMUZgjyOsSCxIVP0OiaizrBNW9MtVdpOJJksry3Le1jv--Bf_MKGg9LDpGWs8HqO9YxLmmKqMLmHbXq3ukR8fHelyeNAJyOTiWGTq4lWm5ErNGpfWwZcTbds11dwAZjjcfd35wpOYkcg4LFANqr8XapvgN3EilBoWfVrajOz6ac8bf5z6t2F1lpIcVKMDQH4rzVSfsWBLkuvvhQBvZMQZDPz9yVKU9Zetd-AhHn9n")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();
        client2 = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client2.send(request2,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            //  Block of code to handle errors
        }
        int startTime = (startHours * 60 * 60) + (startMinutes * 60) + startSeconds;
        int endTime = (endHours * 60 * 60) + (endMinutes * 60) + endSeconds;
        Main m = new Main();
        System.out.println(m.getAvgPressure(startTime, endTime, 100.0, percentage));
        System.out.println(m.getAvgFuel(startTime, endTime, 10.0, percentage/38));
    }
}

