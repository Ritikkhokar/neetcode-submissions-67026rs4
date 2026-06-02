class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)return new ArrayList<>();
        String []arr = {
            "",".;","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz","yz"
            };
        List<String> ans = new ArrayList<>(
                            Arrays.asList(arr[digits.charAt(0) - '0'].split("")) 
                            ); 
        // for(int i=0;i<ans.size();i++){
        //     System.out.print(ans.get(i));
        // } 
        for(int i=1;i<digits.length();i++){
            ans = makeCombinations(ans, new ArrayList<>(
                            Arrays.asList(arr[digits.charAt(i) - '0'].split("")) 
                            ));
        }
        return ans;
    }

    public List<String> makeCombinations(List<String> list1, List<String> list2){
        List<String> ans = new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list2.size();j++){
                ans.add(list1.get(i) + list2.get(j));
            }
        }
        return ans;
    }
}
