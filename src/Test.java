import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test {
	static Map<String, List<String>> vGraphMap = new HashMap<String,List<String>>();
	public static void main(String[] args) {
		List<OperationRelationStructure> ls = initData();
		// ����ڵ����
		int virtualNum = 0;
		
		// 
		Map<String,List<String>> graphMap = new HashMap<String,List<String>>();
		for(int i=0;i<ls.size();i++){
			OperationRelationStructure struct = ls.get(i);
			graphMap.put(struct.getOperation(), struct.getBeforeOperationLs());
			
			
			
		}
		
		System.out.println(graphMap.toString());
		dealOperationMap(virtualNum, graphMap);
		System.out.println(graphMap.toString());
		
		// �ڵ���
		Map<String,StartEnd> nodeMap = new HashMap<String,StartEnd>();
		
		
//		graphMap.s
		//���޽�ǰ����Ŀ�ʼ���
		
		int strat = 1;
		
		//
		List<List<String>> dealedPrerequisite = new  ArrayList<List<String>>();
		
		// ��ʼ��
		for (Entry<String, List<String>> graphElement : graphMap.entrySet()) {
			
			String operation = graphElement.getKey();
			
			List<String> prerequisite = graphElement.getValue();
			
			StartEnd startEnd = new StartEnd();
			
			if(prerequisite.isEmpty()){
				startEnd.start = 1;
			}else{
//				if(prerequisite.containsAll()){
//					
//				}
				
			}
			
			// ��¼�Ѵ���� ���� 
			dealedPrerequisite.add(prerequisite);
			nodeMap.put(operation, startEnd);
		}
		// ����ʼ���
		for (Entry<String, List<String>> graphElement : graphMap.entrySet()) {
			String operation = graphElement.getKey();
			
			// ��ǰ���򼯺�
			List<List<String>>  prerequisiteLs = new ArrayList<List<String>>();
			
			prerequisiteLs.addAll(graphMap.values());
			
			List<String> prerequisite = graphElement.getValue();
			
			for(int i=0;i<prerequisiteLs.size();i++){
				
				List<String> prerequisiteTwo =	prerequisiteLs.get(i);	
				
				
				
				
			}
			
		}
		

	}

	private static void dealOperationMap(int virtualNum, Map<String, List<String>> graphMap) {
		// ��ǰ���򼯺�
				List<List<String>>  prerequisiteLs = new ArrayList<List<String>>();
				
				prerequisiteLs.addAll(graphMap.values());
		
		for (Entry<String, List<String>> graphElement : graphMap.entrySet()) {
			
			String operation = graphElement.getKey();
			
			List<String> prerequisiteOne = graphElement.getValue();
			
			for(int i=0;i<prerequisiteLs.size();i++){
				
				List<String> prerequisiteTwo = prerequisiteLs.get(i);
				
				if(prerequisiteOne.containsAll(prerequisiteTwo)&&!prerequisiteTwo.isEmpty()&&prerequisiteOne.size()!=prerequisiteTwo.size()){
					// ��Ҫ�� operation �� ��ǰ����  prerequisiteOne �е� prerequisiteTwo ���� ���⹤��Ui 
					prerequisiteOne.removeAll(prerequisiteTwo);
					
					String virtualOperation = "U"+(++virtualNum);
					
					// ��� �ü���һ�滻�����⹤�� �������еĴ���
					if(!vGraphMap.isEmpty()){
						
						for(Entry<String, List<String>> VgraphElement : vGraphMap.entrySet()){
							
							String vOpreation = VgraphElement.getKey();
							
							List<String> vPrerequisiteOne = VgraphElement.getValue();
							
							if(vPrerequisiteOne.equals(prerequisiteTwo)){
								virtualOperation = vOpreation;
								
								virtualNum--;
								
								break;
							}
							
						}
					}
					
					
					prerequisiteOne.add(virtualOperation);
					
					// ���� ���⹤��
					graphMap.put(virtualOperation, prerequisiteTwo);
					
					// ��¼���������⹤��
					vGraphMap.put(virtualOperation, prerequisiteTwo);
					
					// ÿ���޸���ɺ� �����µݹ鴦��  
					dealOperationMap(virtualNum, graphMap);
					
					return;
					
				}
				
			}
			
		}
		
	}

	private static List<OperationRelationStructure> initData() {
		List<OperationRelationStructure> ls = new ArrayList<OperationRelationStructure>();
		
		OperationRelationStructure oRSC005 = new OperationRelationStructure();
		oRSC005.setOperation("C005");
		List<String> beforeOperationLsC005 = new ArrayList<String>();
		oRSC005.setBeforeOperationLs(beforeOperationLsC005);
		List<String> nextOperationLs = new ArrayList<String>();
		nextOperationLs.add("C002");
		nextOperationLs.add("C004");
		oRSC005.setNextOperationLs(nextOperationLs );
		ls.add(oRSC005);
		
		OperationRelationStructure oRSC002 = new OperationRelationStructure();
		oRSC002.setOperation("C002");
		List<String> beforeOperationLsC002 = new ArrayList<String>();
		beforeOperationLsC002.add("C005");
		oRSC002.setBeforeOperationLs(beforeOperationLsC002 );
		List<String> nextOperationLsC002 = new ArrayList<String>();
		nextOperationLs.add("C003");
		oRSC002.setNextOperationLs(nextOperationLsC002 );
		ls.add(oRSC002);
		
		OperationRelationStructure oRSC003 = new OperationRelationStructure();
		oRSC003.setOperation("C003");
		List<String> beforeOperationLsC003 = new ArrayList<String>();
		beforeOperationLsC003.add("C002");
		oRSC003.setBeforeOperationLs(beforeOperationLsC003 );
		List<String> nextOperationLsC003 = new ArrayList<String>();
		nextOperationLs.add("C004");
		oRSC003.setNextOperationLs(nextOperationLsC003 );
		ls.add(oRSC003);
		
		OperationRelationStructure oRSC004 = new OperationRelationStructure();
		oRSC004.setOperation("C004");
		List<String> beforeOperationLsC004 = new ArrayList<String>();
		beforeOperationLsC004.add("C005");
		beforeOperationLsC004.add("C003");
		oRSC004.setBeforeOperationLs(beforeOperationLsC004 );
		List<String> nextOperationLsC004 = new ArrayList<String>();
		oRSC004.setNextOperationLs(nextOperationLsC004);
		ls.add(oRSC004);
		return ls;
	}
	
	private static List<OperationRelationStructure> initData2() {
		List<OperationRelationStructure> ls = new ArrayList<OperationRelationStructure>();
		
		
		OperationRelationStructure oRSB = new OperationRelationStructure();
		oRSB.setOperation("B");
		List<String> beforeOperationLsB = new ArrayList<String>();
		beforeOperationLsB.add("A");
		oRSB.setBeforeOperationLs(beforeOperationLsB);
		ls.add(oRSB);
		
		
		
		OperationRelationStructure oRSC = new OperationRelationStructure();
		oRSC.setOperation("C");
		List<String> beforeOperationLsC = new ArrayList<String>();
		beforeOperationLsC.add("A");
		oRSC.setBeforeOperationLs(beforeOperationLsC);
		ls.add(oRSC);
		
		OperationRelationStructure oRSD = new OperationRelationStructure();
		oRSD.setOperation("D");
		List<String> beforeOperationLsD = new ArrayList<String>();
		beforeOperationLsD.add("A");
		oRSD.setBeforeOperationLs(beforeOperationLsD);
		ls.add(oRSD);
		
		OperationRelationStructure oRSE = new OperationRelationStructure();
		oRSE.setOperation("E");
		List<String> beforeOperationLsE = new ArrayList<String>();
		beforeOperationLsE.add("B");
		oRSE.setBeforeOperationLs(beforeOperationLsE);
		ls.add(oRSE);
		
		OperationRelationStructure oRSF = new OperationRelationStructure();
		oRSF.setOperation("F");
		List<String> beforeOperationLsF = new ArrayList<String>();
		beforeOperationLsF.add("B");
		beforeOperationLsF.add("C");
		oRSF.setBeforeOperationLs(beforeOperationLsF);
		ls.add(oRSF);
		
		OperationRelationStructure oRSG = new OperationRelationStructure();
		oRSG.setOperation("G");
		List<String> beforeOperationLsG = new ArrayList<String>();
		beforeOperationLsG.add("B");
		beforeOperationLsG.add("D");
		beforeOperationLsG.add("C");
		oRSG.setBeforeOperationLs(beforeOperationLsG);
		ls.add(oRSG);
		
		OperationRelationStructure oRSH = new OperationRelationStructure();
		oRSH.setOperation("H");
		List<String> beforeOperationLsH = new ArrayList<String>();
		beforeOperationLsH.add("E");
		beforeOperationLsH.add("F");
		beforeOperationLsH.add("G");
		oRSH.setBeforeOperationLs(beforeOperationLsH);
		ls.add(oRSH);
		
		
		OperationRelationStructure oRSA = new OperationRelationStructure();
		oRSA.setOperation("A");
		List<String> beforeOperationLsA = new ArrayList<String>();
		oRSA.setBeforeOperationLs(beforeOperationLsA);
		ls.add(oRSA);
		
		
		return ls;
	}
	
	 /**
     * ʹ�� Map��value��������
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByValue(Map<String, String> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, String>> iter = entryList.iterator();
        Map.Entry<String, String> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }
    

}
class MapValueComparator implements Comparator<Map.Entry<String, String>> {

    @Override
    public int compare(Entry<String, String> me1, Entry<String, String> me2) {

        return me1.getValue().compareTo(me2.getValue());
    }
}
