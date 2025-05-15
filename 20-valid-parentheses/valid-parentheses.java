class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();

        for(char i: s.toCharArray()){
            if(!st.empty()){
                if(st.peek() == '{' && i == '}') st.pop();
                else if(st.peek() == '[' && i == ']') st.pop();
                else if(st.peek() == '(' && i == ')') st.pop();
                else st.push(i);
            }else st.push(i);
        }

        return st.empty();
    }
}