import java.util.ArrayList;

public class OperationGraph {
	
	// 顶点 节点
	private class OperationVNode{
		
		OperationInfo operationInfo; // 数据 部分
		// 下一个 边节点
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
	
	// 边 节点
	private class OperationArcNode{
		// 数据
		OperationInfo operationInfo;
		// 下一个 边节点
		OperationArcNode operationArcNode;
	}
	
	// 记录 顶点 节点
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
				// 在下一工序没有包含 说明是 顶点节点
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
