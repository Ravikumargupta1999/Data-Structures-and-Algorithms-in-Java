import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

// same as public class Kosaraju_Algorithm {
// https://practice.geeksforgeeks.org/problems/strongly-connected-component-tarjanss-algo-1587115621/1/?difficulty[]=2&page=1&company[]=Amazon&company[]=Microsoft&company[]=Google&company[]=Flipkart&company[]=Adobe&company[]=Samsung&company[]=Accolite&company[]=MakeMyTrip&company[]=Zoho&company[]=Snapdeal&company[]=Paytm&company[]=Goldman%20Sachs&company[]=Walmart&company[]=Morgan%20Stanley&company[]=FactSet&company[]=OYO%20Rooms&company[]=D-E-Shaw&company[]=Ola%20Cabs&company[]=SAP%20Labs&company[]=Oracle&company[]=Directi&company[]=Hike&company[]=MAQ%20Software&company[]=VMWare&company[]=Qualcomm&company[]=Facebook&company[]=Visa&company[]=Cisco&company[]=Intuit%20&company[]=Linkedin&company[]=Yahoo&company[]=Payu&company[]=Wipro&company[]=Codenation&company[]=BankBazaar&company[]=Housing.com&company[]=Yatra.com&company[]=TCS&company[]=Salesforce&company[]=Aricent&company[]=Belzabar&company[]=Citrix&company[]=Teradata&company[]=Synopsys&company[]=PayPal&company[]=Media.net%20&company[]=Swiggy&company[]=InMobi&company[]=Nutanix&company[]=Groupon&company[]=Rockstand&company[]=24*7%20Innovation%20Labs&company[]=Twitter&company[]=Brocade&company[]=ABCO&company[]=Times%20Internet&company[]=Apple&company[]=Myntra&company[]=Boomerang%20Commerce&company[]=DE%20Shaw&company[]=One97&company[]=Infosys&company[]=Cognizant%20&company[]=Moonfrog%20Labs&company[]=OATS%20Systems&company[]=Atlassian&company[]=Juniper%20Networks&company[]=Nagarro&company[]=Drishti-Soft&company[]=CouponDunia&company[]=Amdocs&company[]=Accenture&company[]=Tejas%20Network&company[]=GE&company[]=Mahindra%20Comviva&company[]=InfoEdge&company[]=Streamoid%20Technologies&company[]=Opera&company[]=Expedia&company[]=Epic%20Systems&company[]=GreyOrange%20&company[]=IBM&company[]=United%20Health%20Group&company[]=MetLife&company[]=IgniteWorld%20&company[]=Oxigen%20Wallet&company[]=Uber&company[]=Quikr&company[]=Polycom&company[]=Zillious&company[]=TinyOwl&company[]=Kritikal%20Solutions&company[]=CarWale&company[]=Philips&company[]=PropTiger&company[]=Rivigo&company[]=Jabong&company[]=BrowserStack&company[]=Arcesium&company[]=Wooker&company[]=Fab.com&company[]=Bloomberg&company[]=Veritas&company[]=Cadence%20India&company[]=Airtel&company[]=Monotype%20Solutions&company[]=Nvidia&company[]=Xome&company[]=Grofers&company[]=Sapient&company[]=Mobicip&company[]=nearbuy&company[]=PlaySimple&company[]=Citicorp&company[]=Sprinklr&company[]=National%20Instruments&company[]=eBay&company[]=Pubmatic&company[]=Junglee%20Games&company[]=Tesco&company[]=Service%20Now&company[]=Infinera&company[]=Cavisson%20System&company[]=Dailyhunt&company[]=Lybrate&company[]=Intel&company[]=Bidgely&company[]=Netskope%20&company[]=Informatica&company[]=Kuliza&company[]=Dunzo&company[]=Zycus&company[]=Yodlee%20Infotech&company[]=American%20Express&company[]=Komli%20Media&company[]=JUSPAY&company[]=HunanAsset&company[]=Unisys&company[]=Motlay&company[]=CGI&company[]=Medlife&company[]=Target%20Corporation&company[]=Taxi4Sure&company[]=Zomato&company[]=Freshokartz&company[]=Dell&company[]=redBus&company[]=HSBC&company[]=FreeCharge&company[]=Vizury%20Interactive%20Solutions&company[]=HCL&company[]=Huawei&company[]=Open%20Solutions&company[]=Amadeus%20Labs&company[]=Code%20Brew&company[]=Thoughtworks&company[]=Zopper&company[]=KLA%20Tencor&company[]=Deloitte&company[]=Mallow%20Technologies&company[]=MindFire%20Solutions&company[]=Knowlarity&company[]=Practo&query=difficulty[]2page1company[]Amazoncompany[]Microsoftcompany[]Googlecompany[]Flipkartcompany[]Adobecompany[]Samsungcompany[]Accolitecompany[]MakeMyTripcompany[]Zohocompany[]Snapdealcompany[]Paytmcompany[]Goldman%20Sachscompany[]Walmartcompany[]Morgan%20Stanleycompany[]FactSetcompany[]OYO%20Roomscompany[]D-E-Shawcompany[]Ola%20Cabscompany[]SAP%20Labscompany[]Oraclecompany[]Directicompany[]Hikecompany[]MAQ%20Softwarecompany[]VMWarecompany[]Qualcommcompany[]Facebookcompany[]Visacompany[]Ciscocompany[]Intuit%20company[]Linkedincompany[]Yahoocompany[]Payucompany[]Wiprocompany[]Codenationcompany[]BankBazaarcompany[]Housing.comcompany[]Yatra.comcompany[]TCScompany[]Salesforcecompany[]Aricentcompany[]Belzabarcompany[]Citrixcompany[]Teradatacompany[]Synopsyscompany[]PayPalcompany[]Media.net%20company[]Swiggycompany[]InMobicompany[]Nutanixcompany[]Grouponcompany[]Rockstandcompany[]24*7%20Innovation%20Labscompany[]Twittercompany[]Brocadecompany[]ABCOcompany[]Times%20Internetcompany[]Applecompany[]Myntracompany[]Boomerang%20Commercecompany[]DE%20Shawcompany[]One97company[]Infosyscompany[]Cognizant%20company[]Moonfrog%20Labscompany[]OATS%20Systemscompany[]Atlassiancompany[]Juniper%20Networkscompany[]Nagarrocompany[]Drishti-Softcompany[]CouponDuniacompany[]Amdocscompany[]Accenturecompany[]Tejas%20Networkcompany[]GEcompany[]Mahindra%20Comvivacompany[]InfoEdgecompany[]Streamoid%20Technologiescompany[]Operacompany[]Expediacompany[]Epic%20Systemscompany[]GreyOrange%20company[]IBMcompany[]United%20Health%20Groupcompany[]MetLifecompany[]IgniteWorld%20company[]Oxigen%20Walletcompany[]Ubercompany[]Quikrcompany[]Polycomcompany[]Zilliouscompany[]TinyOwlcompany[]Kritikal%20Solutionscompany[]CarWalecompany[]Philipscompany[]PropTigercompany[]Rivigocompany[]Jabongcompany[]BrowserStackcompany[]Arcesiumcompany[]Wookercompany[]Fab.comcompany[]Bloombergcompany[]Veritascompany[]Cadence%20Indiacompany[]Airtelcompany[]Monotype%20Solutionscompany[]Nvidiacompany[]Xomecompany[]Groferscompany[]Sapientcompany[]Mobicipcompany[]nearbuycompany[]PlaySimplecompany[]Citicorpcompany[]Sprinklrcompany[]National%20Instrumentscompany[]eBaycompany[]Pubmaticcompany[]Junglee%20Gamescompany[]Tescocompany[]Service%20Nowcompany[]Infineracompany[]Cavisson%20Systemcompany[]Dailyhuntcompany[]Lybratecompany[]Intelcompany[]Bidgelycompany[]Netskope%20company[]Informaticacompany[]Kulizacompany[]Dunzocompany[]Zycuscompany[]Yodlee%20Infotechcompany[]American%20Expresscompany[]Komli%20Mediacompany[]JUSPAYcompany[]HunanAssetcompany[]Unisyscompany[]Motlaycompany[]CGIcompany[]Medlifecompany[]Target%20Corporationcompany[]Taxi4Surecompany[]Zomatocompany[]Freshokartzcompany[]Dellcompany[]redBuscompany[]HSBCcompany[]FreeChargecompany[]Vizury%20Interactive%20Solutionscompany[]HCLcompany[]Huaweicompany[]Open%20Solutionscompany[]Amadeus%20Labscompany[]Code%20Brewcompany[]Thoughtworkscompany[]Zoppercompany[]KLA%20Tencorcompany[]Deloittecompany[]Mallow%20Technologiescompany[]MindFire%20Solutionscompany[]Knowlaritycompany[]Practo
public class Video_21_Strongly_connected_component {
    public ArrayList<ArrayList<Integer>> tarjans(int v, ArrayList<ArrayList<Integer>> adj) {
        // step 1
        boolean[] visited = new boolean[v];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs1(i, adj, stack, visited);
            }
        }

        // step 2
        ArrayList<ArrayList<Integer>> ngraph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            ngraph.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> nbrs = adj.get(i);
            for (int nbr : nbrs) {
                ngraph.get(nbr).add(i);
            }
        }

        // step 3;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        visited = new boolean[v];
        while (stack.size() > 0) {
            int rem = stack.removeFirst();
            if (!visited[rem]) {
                ArrayList<Integer> al = new ArrayList<>();
                dfs2(rem, ngraph, visited, al);
                Collections.sort(al);
                ans.add(al);
            }
        }
        Collections.sort(ans, (a, b) -> {
            return a.get(0) - b.get(0);
        });
        return ans;
    }

    public void dfs1(int src, ArrayList<ArrayList<Integer>> graph, LinkedList<Integer> stack, boolean[] visited) {
        visited[src] = true;
        ArrayList<Integer> nbrs = graph.get(src);
        for (int nbr : nbrs) {
            if (!visited[nbr]) {
                dfs1(nbr, graph, stack, visited);
            }
        }
        stack.addFirst(src);
    }

    public void dfs2(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visited, ArrayList<Integer> ans) {
        visited[src] = true;
        ans.add(src);
        ArrayList<Integer> nbrs = graph.get(src);
        for (int nbr : nbrs) {
            if (!visited[nbr]) {
                dfs2(nbr, graph, visited, ans);
            }
        }
    }

    public static void main(String[] args) {
//        int v = 8;
//        int[][] graph = {{0, 1}, {0, 3}, {0, 4}, {0, 7}, {1, 3}, {1, 5}, {1, 7}, {2, 7}, {3, 4}, {5, 6}, {5, 7}};
//        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int v = 5;
        int[][] graph = {{0, 2}, {0, 3}, {1, 0}, {2, 1}, {3, 4}};
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            al.get(graph[i][0]).add(graph[i][1]);
        }
        Video_21_Strongly_connected_component st = new Video_21_Strongly_connected_component();
        System.out.println(st.tarjans(v, al));
    }
}
