class Solution {

    private char solve(char op, List<Character>values){
        if (op == '!') 
            return values.get(0) == 't' ? 'f' : 't';

        if (op == '&') 
            return values.stream().anyMatch(ch -> ch == 'f') ? 'f' : 't';

        if (op == '|') 
            return values.stream().anyMatch(ch -> ch == 't') ? 't' : 'f';

        return 't';
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character>stack = new Stack<>();
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(ch==',') continue;
            if(ch==')'){
                List<Character>values = new ArrayList<>();
                while(stack.peek()!='('){
                    values.add(stack.pop());
                }
                stack.pop();
                char op = stack.pop();
                stack.push(solve(op, values));
            }
                else{
                    stack.push(ch);
                }
            
        }
        return stack.peek()=='t';
    }
}
