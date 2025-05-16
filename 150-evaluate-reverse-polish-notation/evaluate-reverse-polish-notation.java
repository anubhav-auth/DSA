class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for(String i: tokens){
            switch(i){
                case "+" -> {
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b+a);
                }
                case "-" -> {
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b-a);
                }
                case "*" -> {
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b*a);
                }
                case "/" -> {
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b/a);
                }
                default -> { 
                    s.push(Integer.parseInt(i));
                }
            }
        }

        return s.pop();
    }
}