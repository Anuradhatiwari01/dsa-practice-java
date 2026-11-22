class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String st : strs){
            char[] arr = st.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);

            if(map.containsKey(key)){
                map.get(key).add(st);
            }
            else{
                map.put(key, new ArrayList<>());
                map.get(key).add(st);
            }
        }
        for(List<String> group : map.values()){
            result.add(group);
        }
        return result;  
    }
}