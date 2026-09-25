class Solution {
    String expression;
    int idx;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.idx = 0;
        
        Set<String> ret = expr();
        List<String> sorted = new ArrayList<>(ret);
        Collections.sort(sorted);
        return sorted;
    }

    private Set<String> expr(){
        Set<String> ret = new TreeSet<String>();
        
        do {
            Set<String> termResult = term();
            ret.addAll(termResult);
            
            if(idx < expression.length() && expression.charAt(idx) == ','){
                idx++; // skip ','
            }
            else{
                break;
            }
        } while(true);
        
        return ret;
    }

    private Set<String> term(){
        Set<String> ret = new TreeSet<String>();
        ret.add(""); 
        
        while(
            idx < expression.length() &&
            (expression.charAt(idx) == '{' || 
             Character.isLetter(expression.charAt(idx)))
        ) {
            Set<String> sub = item();
            Set<String> tmp = new TreeSet<String>();

            for(String left : ret){
                for(String right : sub){
                    tmp.add(left + right);
                }
            }
            ret = tmp;
        }
        return ret;
    }

    private Set<String> item(){
        Set<String> ret = new TreeSet<String>();
        
        if(expression.charAt(idx) == '{'){
            idx++; 
            ret = expr();
            if(idx < expression.length()) {
                idx++; 
            }
        }
        else{
            StringBuilder sb = new StringBuilder();
            while(idx < expression.length() && Character.isLetter(expression.charAt(idx))){
                sb.append(expression.charAt(idx));
                idx++;
            }
            ret.add(sb.toString());
        }
        return ret;
    }
}