
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:记录用户或者对象某一种类型的评价（对象包括客户和商家，客户和商家可以是同一人）的得分
	*/
    public class ObjectScoreInfo implements Serializable
    {
        public ObjectScoreInfo()
        { }
		
		

		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*逻辑编号
		*/
		private String   _oSId;//逻辑编号
		/**
		*评分类别
		*/
		private String   _typeId;//评分类别
		/**
		*打分次数
		*/
		private int   _numberOfTimes;//打分次数
		/**
		*得分
		*/
		private int   _score;//得分
		/**
		*评语
		*/
		private String   _describle;//评语
		/**
		*评分对象表
		*/
		private String   _tableName;//评分对象表
		/**
		*评分对象编号
		*/
		private String   _objectId;//评分对象编号
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		private  TypeMenuInfo  _typeMenuInfo;
		
		//list FK
 private List<ScoreTypeListInfo> _scoreTypeListInfos;
		
		
		
		
 /**
	*编号
	*/
	public String getId()
	{
	
		 return _id; 
	}
	/**
	*编号
	*/
	public void  setId (String  Id )
	{
		_id = Id ;
	}
	
	
	/**
	*逻辑编号
	*/
	public String getOSId()
	{
	
		 return _oSId; 
	}
	/**
	*逻辑编号
	*/
	public void  setOSId (String  OSId )
	{
		_oSId = OSId ;
	}
	
	
	/**
	*评分类别
	*/
	public String getTypeId()
	{
	
		 return _typeId; 
	}
	/**
	*评分类别
	*/
	public void  setTypeId (String  TypeId )
	{
		_typeId = TypeId ;
	}
	
	
	/**
	*打分次数
	*/
	public int getNumberOfTimes()
	{
	
		 return _numberOfTimes; 
	}
	/**
	*打分次数
	*/
	public void  setNumberOfTimes (int  NumberOfTimes )
	{
		_numberOfTimes = NumberOfTimes ;
	}
	
	
	/**
	*得分
	*/
	public int getScore()
	{
	
		 return _score; 
	}
	/**
	*得分
	*/
	public void  setScore (int  Score )
	{
		_score = Score ;
	}
	
	
	/**
	*评语
	*/
	public String getDescrible()
	{
	
		 return _describle; 
	}
	/**
	*评语
	*/
	public void  setDescrible (String  Describle )
	{
		_describle = Describle ;
	}
	
	
	/**
	*评分对象表
	*/
	public String getTableName()
	{
	
		 return _tableName; 
	}
	/**
	*评分对象表
	*/
	public void  setTableName (String  TableName )
	{
		_tableName = TableName ;
	}
	
	
	/**
	*评分对象编号
	*/
	public String getObjectId()
	{
	
		 return _objectId; 
	}
	/**
	*评分对象编号
	*/
	public void  setObjectId (String  ObjectId )
	{
		_objectId = ObjectId ;
	}
	
	
	/**
	*预留字段
	*/
	public String getField()
	{
	
		 return _field; 
	}
	/**
	*预留字段
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
 
	
		



