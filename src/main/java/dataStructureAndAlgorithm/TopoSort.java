package dataStructureAndAlgorithm;

import java.util.*;

public class TopoSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Character, Vertex> map = new HashMap<Character, Vertex>();

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

        Queue<Character> queue = new LinkedList<Character>();
        for (Map.Entry<Character, Vertex> entry : map.entrySet()) {
            if(entry.getValue().inDegree == 0){
                queue.add(entry.getKey());
            }
        }
        List<Character> resultList = new ArrayList<Character>();

        while ( !queue.isEmpty() ){
            Character vertexId = queue.poll();
            resultList.add(vertexId);

            //后继节点的入度减1
            for(char id : map.get(vertexId).adjVertexs){
                map.get(id).inDegree--;
                if(map.get(id).inDegree == 0){
                    queue.add(id);
                }
            }
        }

        if(resultList.size() < map.size()){
            System.out.println("有环路");
        }else{
            System.out.println(resultList);
        }
    }
}

class Vertex{
    public char id;                      // 顶点标识
    public List<Character> adjVertexs = new ArrayList<Character>();   //存储后继节点（个数即出度）
    public int inDegree;               // 该顶点的入度
    public boolean visited;

    public Vertex(char id) {
        this.id = id;
        inDegree = 0;
        visited = false;
    }

    public void addAdjVertexs(char adjVertex){
        adjVertexs.add(adjVertex);
    }
}

