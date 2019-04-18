import java.util.ArrayList;

public class LGraph {
	//�����ڵ�
	private class VNode{
		int data;              //�������
		ArcNode firstArc;      //ָ���һ����
		
		
		
		
		public VNode(int data, ArcNode firstArc) {
			this.data = data;
			this.firstArc = firstArc;
		}
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public ArcNode getFirstArc() {
			return firstArc;
		}
		public void setFirstArc(ArcNode firstArc) {
			this.firstArc = firstArc;
		}
		
		
	}
	
	//�߱���
	private class ArcNode{
		int adjvex;           //�ñ�ָ���յ�����
		ArcNode nextarc;      //��һ���ߵ�ָ�� 
		int len;              //�ñߵĳ���
		
		public ArcNode(int adjvex, ArcNode nextarc, int len) {
			super();
			this.adjvex = adjvex;
			this.nextarc = nextarc;
			this.len = len;
		}

		public int getAdjvex() {
			return adjvex;
		}

		public void setAdjvex(int adjvex) {
			this.adjvex = adjvex;
		}

		public ArcNode getNextarc() {
			return nextarc;
		}

		public void setNextarc(ArcNode nextarc) {
			this.nextarc = nextarc;
		}

		public int getLen() {
			return len;
		}

		public void setLen(int len) {
			this.len = len;
		}
		
		
		
		
	}
	
	ArrayList<VNode> vNodes;
	int numOfVetex;
	int numOfEdges;
	
	public LGraph() {
		vNodes=new ArrayList<VNode>();
		numOfVetex=0;
		numOfEdges=0;
	}
	
	public LGraph(int[][] edges,int n){
		numOfVetex=n;
		numOfEdges=0;
		// ��ʼ�� �����ڵ�
		vNodes=new ArrayList<VNode>();
		for(int i=0;i<n;i++){
			VNode v=new VNode(i,null);
			vNodes.add(v);
		}
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				if(edges[i][j]!=0&&edges[i][j]!=-1){
					ArcNode arc=new ArcNode(j,null,edges[i][j]);
					VNode v=vNodes.get(i);
					arc.setNextarc(v.getFirstArc());
					v.setFirstArc(arc);
					numOfEdges++;
				}
			}
	}
	
	public void disp(){
		for(int i=0;i<vNodes.size();i++){
			System.out.print("Node:"+vNodes.get(i).getData());
			ArcNode arc=vNodes.get(i).getFirstArc();
			while(arc!=null){
				System.out.print("-->"+arc.getAdjvex());
				arc=arc.getNextarc();
			}
			System.out.println();
		}
	}
	
	//������������ĸ�������
	private void DFSREC(int v,int visited[]){
		System.out.print(v+"-->");
		visited[v]=1;
		ArcNode arc=vNodes.get(v).getFirstArc();
		while(arc!=null){
			if(visited[arc.getAdjvex()]==0)
				DFSREC(arc.getAdjvex(),visited);
			arc=arc.getNextarc();
		}
	}
	
	//�����������
	public void DFS(int v){
		int[] visited=new int[numOfVetex];
		DFSREC(v,visited);
	}
	
	//�����������
	public void BFS(int v){
		int[] qu=new int[numOfVetex];
		int tail=0;
		int head=0;
		int[] visited=new int[numOfVetex];
		qu[tail++]=v;
		while(head!=tail){
			int t=qu[head++];
			visited[t]=1;
			System.out.print(t+"-->");
			ArcNode arc=vNodes.get(t).getFirstArc();
			while(arc!=null){
				if(visited[arc.getAdjvex()]!=1){
					qu[tail++]=arc.getAdjvex();
				}
				arc=arc.getNextarc();
			}
		}
	}
	
	//���ڽӱ�洢��ͼת��Ϊ����洢��ͼ
	public MGraph toMGraph(){
		int[][] edges=new int[numOfVetex][numOfVetex];
		for(int i=0;i<vNodes.size();i++){
			edges[i][i]=0;
			ArcNode arc=vNodes.get(i).getFirstArc();
			while(arc!=null){
				edges[i][arc.getAdjvex()]=arc.getLen();
				arc=arc.getNextarc();
			}
		}
		MGraph m=new MGraph(edges,numOfVetex);
		return m;
		
	}
	
	public static void main(String args[]){
		int[][] edges={{0,2,-1,-1},{-1,0,3,1},{-1,-1,0,4},{5,-1,-1,0}};
		LGraph l=new LGraph(edges,4);
		MGraph m=l.toMGraph();
		l.disp();
//		m.BFS(1);
	}
	
	
	

}

