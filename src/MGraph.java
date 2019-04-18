public class MGraph {
	
	
	 private int[][] edges;//�ڽӾ���
	 private int numOfEdges;//�ߵ���Ŀ
	 private int numOfVetex;//�������Ŀ
	 
	//��ʼ��һ���ڽӾ��� 
	public MGraph(int n) {
		edges = new int[n][n];
		numOfEdges = 0;
		numOfVetex = n;
	}
	
	//��ʼ��һ���ڽӾ�������һ��n*n�ľ���Ϊ�丳ֵ
	public MGraph(int[][] edges,int n){
		numOfVetex=n;
		numOfEdges=0;
		this.edges = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				this.edges[i][j]=edges[i][j];
				if((edges[i][j]!=-1)&&(edges[i][j]!=0)){
					numOfEdges++;
				}
			}
		}
	}
	
	//��ĳһ�����㿪ʼ�Ը�ͼ���������������
	public void DFS(int v) {
		int[] visited = new int[numOfVetex];
		for (int i = 0; i < numOfVetex; i++) {
			visited[i] = 0;
		}
		DFSREC(v, visited);
		System.out.println();
		int flag=1;
		for(int i=0;i<visited.length;i++){
			if(visited[i]==0)
			{
				flag=0;
				break;
			}
		}
		if(flag==1)
			System.out.println("�ѱ�����ȫͼ");
		else
			System.out.println("�Ӹõ�����޷�����ȫͼ");

	}
	
	//�������������������
	private void DFSREC(int v, int visited[]) {
		visited[v] = 1;
		System.out.print(v + "-->");
		for (int i = 0; i < numOfVetex; i++) {
			if (edges[v][i] != -1 && edges[v][i] != 0 && visited[i] != 1) {
				DFSREC(i, visited);
			}
		}
	}
	
	//�����������
	public void BFS(int v) {
		int[] qu=new int[numOfVetex];
		int[] visited=new int[numOfVetex];
		int head=0;
		int tail=0;
		qu[tail++]=v;
		visited[v]=1;
		while(head!=tail){
			int t=qu[head++];
			System.out.print(t+"-->");
			for(int i=0;i<numOfVetex;i++){
				if(edges[t][i]!=-1&&edges[t][i]!=0&&visited[i]==0)
				{
					qu[tail++]=i;
					visited[i]=1;
				}
				
			}
		}
		
	}
	
	//���Ը�ͼ�Ƿ�Ϊ��ͨͼ
	public boolean isConnect(){
		int[] visited = new int[numOfVetex];
		for (int i = 0; i < numOfVetex; i++) {
			visited[i] = 0;
		}
		DFSREC(0, visited);
		
		for(int i=0;i<visited.length;i++){
			if(visited[i]==0)
				return false;
		}
		return true;
	}
	
	//����Ӷ���u������v�����г���Ϊl��·��
	//path����������¼��ǰ�Ѿ��߹���·��
	//d��������ǰ�߹��ĳ���
	private void pathAllREC(int u,int v,int l,int d,int[] visited,int[] path){
		visited[u]=1;
		d++;
		path[d]=u;
		if(u==v&&d==l){
			for(int i=0;i<=d;i++)
				if(i==d){
					System.out.print(path[i]);
				}
				else{
					System.out.print(path[i]+"-->");
				}
		}
		else{
			for(int t=0;t<numOfVetex;t++){
				if(visited[t]!=1&&edges[u][t]!=0&&edges[u][t]!=-1){
					pathAllREC(t, v, l, d, visited, path);
				}
			}
			visited[u]=0;
		}
	}
	
	//����Ӷ���u������v�����г���Ϊl��·��
	//path����������¼��ǰ�Ѿ��߹���·��
	//d��������ǰ�߹��ĳ���
	public void pathAll(int u,int v,int l){
		int d=-1;
		int[] visited=new int[numOfVetex];
		int[] path=new int[numOfVetex];
		pathAllREC(u,v,l,d,visited,path);
	}
	
	
	
	
	
	public static void main(String args[]){
		int[][] edges={{0,2,-1,-1},{-1,0,3,1},{-1,-1,0,4},{5,-1,-1,0}};
		MGraph m=new MGraph(edges,4);
		m.pathAll(0, 3, 3);
//		if(m.isConnect()==true)
//			System.out.println("YES");
		
	}
	 
	 

}
