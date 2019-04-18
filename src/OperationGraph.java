import java.util.ArrayList;

public class OperationGraph {
	
	// ���� �ڵ�
	private class OperationVNode{
		
		OperationInfo operationInfo; // ���� ����
		// ��һ�� �߽ڵ�
		OperationArcNode operationArcNode;
		public OperationInfo getOperationInfo() {
			return operationInfo;
		}

		public void setOperationInfo(OperationInfo operationInfo) {
			this.operationInfo = operationInfo;
		}

		public OperationArcNode getOperationArcNode() {
			return operationArcNode;
		}

		public void setOperationArcNode(OperationArcNode operationArcNode) {
			this.operationArcNode = operationArcNode;
		}

		
		
		
	}
	
	// �� �ڵ�
	private class OperationArcNode{
		// ����
		OperationInfo operationInfo;
		// ��һ�� �߽ڵ�
		OperationArcNode operationArcNode;
	}
	
	// ��¼ ���� �ڵ�
	ArrayList<OperationVNode> operationVNodeLs = new ArrayList<OperationVNode>();
	
	
	/**
	 * 
	 */
	public OperationGraph(ArrayList<OperationRelationSetting> operationRelationSettingLs){
		ArrayList<OperationInfo> CurentOperationLs = new ArrayList<OperationInfo>();
		ArrayList<OperationInfo> NextOperationLs =  new ArrayList<OperationInfo>();
		
		for(int i=0;i<operationRelationSettingLs.size();i++){
			OperationRelationSetting  operationRelationSetting = operationRelationSettingLs.get(i);
			CurentOperationLs.add(operationRelationSetting.getCurentOperation());
			NextOperationLs.add(operationRelationSetting.getNextOperation());
		}
		
		
		ArrayList<OperationInfo> VCurentOperationLs = new ArrayList<OperationInfo>();
		for (OperationInfo CurentoperationInfo : CurentOperationLs) {
			if(NextOperationLs.contains(CurentoperationInfo)){
				
			}else{
				// ����һ����û�а��� ˵���� ����ڵ�
				VCurentOperationLs.add(CurentoperationInfo);
			}
			
		}
		
		
		
		
		
		
		int intVNode = VCurentOperationLs.size();
		
		for(int i=0;i<intVNode;i++){
			OperationVNode OperationVNode = new OperationVNode();
			OperationVNode.operationInfo = VCurentOperationLs.get(i);
			operationVNodeLs.add(OperationVNode);
		}
		
		
		
		
		
	}
	
	

}
