
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��Ա�ĵȼ�
	*/
    public class LevelInfo implements Serializable
    {
        public LevelInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�ȼ�����
		*/
		private String   _name;//�ȼ�����
		/**
		*����
		*/
		private String   _describe;//����
		/**
		*�������
		*/
		private int   _accumulatedRewardPoints;//�������
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		
		//list FK
 private List<LevelRoleInfo> _levelRoleInfos;
 private List<OfUser> _ofUsers;
		
		
		
		
		/**
		*���
		*/
		public String getId()
		{
		
			 return _id; 
		}
		/**
		*���
		*/
		public void  setId (String  Id )
		{
			_id = Id ;
		}
		
		
		/**
		*�ȼ�����
		*/
		public String getName()
		{
		
			 return _name; 
		}
		/**
		*�ȼ�����
		*/
		public void  setName (String  Name )
		{
			_name = Name ;
		}
		
		
		/**
		*����
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*����
		*/
		public void  setDescribe (String  Describe )
		{
			_describe = Describe ;
		}
		
		
		/**
		*�������
		*/
		public int getAccumulatedRewardPoints()
		{
		
			 return _accumulatedRewardPoints; 
		}
		/**
		*�������
		*/
		public void  setAccumulatedRewardPoints (int  AccumulatedRewardPoints )
		{
			_accumulatedRewardPoints = AccumulatedRewardPoints ;
		}
		
		
		/**
		*Ԥ���ֶ�
		*/
		public String getField()
		{
		
			 return _field; 
		}
		/**
		*Ԥ���ֶ�
		*/
		public void  setField (String  Field )
		{
			_field = Field ;
		}
		
	
		
		
		
		
				//list FK
     		public List< LevelRoleInfo>  getLevelRoleInfos()
		{
		return _levelRoleInfos;
		}
		
		public void  setLevelRoleInfos(List<LevelRoleInfo>  LevelRoleInfos)
		{
		 _levelRoleInfos =LevelRoleInfos;
		
		}
       		public List< OfUser>  getOfUsers()
		{
		return _ofUsers;
		}
		
		public void  setOfUsers(List<OfUser>  OfUsers)
		{
		 _ofUsers =OfUsers;
		
		}
    }
 
	
		



