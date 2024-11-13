package Biweekly_Contest_69;

public class Capitalize_the_Title {
    public String capitalizeTitle(String title) {
        String[] arr = title.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() < 3)
                arr[i] = convertLower(arr[i]);
            else
            {
                arr[i] = Character.toUpperCase(arr[i].charAt(0))+""+convertLower(arr[i].substring(1));
            }
        }
        String res = "";
        for (int i=0;i<arr.length-1;i++)
            res = res + arr[i]+" ";
        return res + arr[arr.length-1];
    }

    public String convertLower(String st) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.length(); i++)
            sb.append(Character.toLowerCase(st.charAt(i)));
        return sb.toString();
    }

}