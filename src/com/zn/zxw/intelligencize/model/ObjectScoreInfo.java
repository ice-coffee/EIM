
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��¼�û����߶���ĳһ�����͵����ۣ���������ͻ����̼ң��ͻ����̼ҿ�����ͬһ�ˣ��ĵ÷�
	*/
    public class ObjectScoreInfo implements Serializable
    {
        public ObjectScoreInfo()
        { }
		
		

		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _oSId;//�߼����
		/**
		*�������
		*/
		private String   _typeId;//�������
		/**
		*��ִ���
		*/
		private int   _numberOfTimes;//��ִ���
		/**
		*�÷�
		*/
		private int   _score;//�÷�
		/**
		*����
		*/
		private String   _describle;//����
		/**
		*���ֶ����
		*/
		private String   _tableName;//���ֶ����
		/**
		*���ֶ�����
		*/
		private String   _objectId;//���ֶ�����
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  TypeMenuInfo  _typeMenuInfo;
		
		//list FK
 private List<ScoreTypeListInfo> _scoreTypeListInfos;
		
		
		
		
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
	*�߼����
	*/
	public String getOSId()
	{
	
		 return _oSId; 
	}
	/**
	*�߼����
	*/
	public void  setOSId (String  OSId )
	{
		_oSId = OSId ;
	}
	
	
	/**
	*�������
	*/
	public String getTypeId()
	{
	
		 return _typeId; 
	}
	/**
	*�������
	*/
	public void  setTypeId (String  TypeId )
	{
		_typeId = TypeId ;
	}
	
	
	/**
	*��ִ���
	*/
	public int getNumberOfTimes()
	{
	
		 return _numberOfTimes; 
	}
	/**
	*��ִ���
	*/
	public void  setNumberOfTimes (int  NumberOfTimes )
	{
		_numberOfTimes = NumberOfTimes ;
	}
	
	
	/**
	*�÷�
	*/
	public int getScore()
	{
	
		 return _score; 
	}
	/**
	*�÷�
	*/
	public void  setScore (int  Score )
	{
		_score = Score ;
	}
	
	
	/**
	*����
	*/
	public String getDescrible()
	{
	
		 return _describle; 
	}
	/**
	*����
	*/
	public void  setDescrible (String  Describle )
	{
		_describle = Describle ;
	}
	
	
	/**
	*���ֶ����
	*/
	public String getTableName()
	{
	
		 return _tableName; 
	}
	/**
	*���ֶ����
	*/
	public void  setTableName (String  TableName )
	{
		_tableName = TableName ;
	}
	
	
	/**
	*���ֶ�����
	*/
	public String getObjectId()
	{
	
		 return _objectId; 
	}
	/**
	*���ֶ�����
	*/
	public void  setObjectId (String  ObjectId )
	{
		_objectId = ObjectId ;
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
	

	
	
	
	public TypeMenuInfo  getTypeMenuInfo()
	{
	return _typeMenuInfo;
	}
	
	public void  setTypeMenuInfo(TypeMenuInfo  TypeMenuInfo)
	{
	 _typeMenuInfo =TypeMenuInfo;
	
	}
	
		
		
				//list FK
     		public List< ScoreTypeListInfo>  getScoreTypeListInfos()
		{
		return _scoreTypeListInfos;
		}
		
		public void  setScoreTypeListInfos(List<ScoreTypeListInfo>  ScoreTypeListInfos)
		{
		 _scoreTypeListInfos =ScoreTypeListInfos;
		
		}
    }
 
	
		



