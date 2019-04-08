package dataStructureAndAlgorithm;

import java.util.*;

public class TopoSortByDFS {

    public static List<Character> resultList = new ArrayList<Character>();
    public static Map<Character, Vertex> map = new HashMap<Character, Vertex>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            String line = in.nextLine();
            if(line.length() > 2){
                //before指向after的边
                char before = line.charAt(0);
                char after = line.charAt(2);

                //对于前面的节点，要添加after到它的后继节点序列中
                if( !map.containsKey(before) )
                    map.put(before, new Vertex(before));
                map.get(before).addAdjVertexs(after);
                //对于后面的节点要改变入度
                if(!map.containsKey(after))
                    map.put(after, new Vertex(after));
                map.get(after).inDegree++;
            }
        }

        for (Map.Entry<Character, Vertex> entry : map.entrySet()) {
            if(entry.getValue().inDegree == 0 && entry.getValue().visited == false){
                DFS(entry.getValue().id);
            }
        }
        System.out.println(resultList);
    }

    public static void DFS(char id){
        //获取当前节点的id，然后访问该节点
        Vertex vertex = map.get(id);
        vertex.visited = true;
        resultList.add(vertex.id);
        for(char i : vertex.adjVertexs){
            if( !map.get(i).visited ){
                map.get(i).inDegree--;
                DFS(i);
            }
        }
    }
}
