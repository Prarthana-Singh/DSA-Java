class Solution {
    public String makeFancyString(String s) {
     
      StringBuilder ans = new StringBuilder();
      for(char ch: s.toCharArray()){
        if(ans.length()<2 || ans.charAt(ans.length()-1)!= ch || ans.charAt(ans.length()-2)!= ch){
            ans.append(ch);
        }
      }
      return ans+"";
    }
}
