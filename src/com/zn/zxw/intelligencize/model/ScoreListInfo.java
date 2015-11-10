
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:对象与评价信息表关联
	*/
    public class ScoreListInfo implements Serializable
    {
        public ScoreListInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*得分列表以Json形式保存
		*/
		private String   _scoreList;//得分列表以Json形式保存
		
		//list FK
 private List<ObjectScoreInfo> _objectScoreInfos;
 private List<PictrueInformationInfo> _pictrueInformationInfos;
 private List<ShopInformationInfo> _shopInformationInfos;
 private List<OfUser> _ofUsers;
		
		
		
		
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
		*得分列表以Json形式保存
		*/
		public String getScoreList()
		{
		
			 return _scoreList; 
		}
		/**
		*得分列表以Json形式保存
		*/
		public void  setScoreList (String  ScoreList )
		{
			_scoreList = ScoreList ;
		}
		
	
		
		
		
		
				//list FK
     		public List< ObjectScoreInfo>  getObjectScoreInfos()
		{
		return _objectScoreInfos;
		}
		
		public void  setObjectScoreInfos(List<ObjectScoreInfo>  ObjectScoreInfos)
		{
		 _objectScoreInfos =ObjectScoreInfos;
		
		}
       		public List< PictrueInformationInfo>  getPictrueInformationInfos()
		{
		return _pictrueInformationInfos;
		}
		
		public void  setPictrueInformationInfos(List<PictrueInformationInfo>  PictrueInformationInfos)
		{
		 _pictrueInformationInfos =PictrueInformationInfos;
		
		}
       		public List< ShopInformationInfo>  getShopInformationInfos()
		{
		return _shopInformationInfos;
		}
		
		public void  setShopInformationInfos(List<ShopInformationInfo>  ShopInformationInfos)
		{
		 _shopInformationInfos =ShopInformationInfos;
		
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
 
	
		



