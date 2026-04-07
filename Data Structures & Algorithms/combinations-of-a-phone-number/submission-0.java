class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }else{
            return letterCombinations1(digits);
        }
        
    }

    public static List<String> letterCombinations1(String digits){
     if(digits.length() == 0)
        {
             List<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        }
        String []arr = {"",".;","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz","yz"};
        //23
        char ch = digits.charAt(0); //2
        String remstr =digits.substring(1); //1
        List<String> rres=letterCombinations1(remstr);
        List<String> myres=new ArrayList<>();
        String alphabets = arr[ch-'0'];
        
        for(int i=0;i<alphabets.length();i++)
        {
            char letter = alphabets.charAt(i);
            for(int j=0;j<rres.size();j++)
            {
                String last = rres.get(j);
                myres.add(letter+last);
            }
        }
        return myres;
    }
}