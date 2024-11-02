class Solution {
    public boolean isCircularSentence(String sentence) {
        if(sentence==null || sentence.isEmpty()){return false;}
        char start = sentence.charAt(0);
        char lastChar = sentence.charAt(sentence.length()-1);
        if(start!=lastChar){
            return false;
        }
        for(int i=0;i<sentence.length();i++){
          if(sentence.charAt(i)==' '){
            if(sentence.charAt(i+1)!=lastChar){
                return false;
            }else{
                lastChar = sentence.charAt(i);
            }
          }else{
            lastChar = sentence.charAt(i);
          }

        }
        return true; 
    }
}
