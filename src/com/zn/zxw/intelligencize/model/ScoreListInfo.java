
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:������������Ϣ�����
	*/
    public class ScoreListInfo implements Serializable
    {
        public ScoreListInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�÷��б���Json��ʽ����
		*/
		private String   _scoreList;//�÷��б���Json��ʽ����
		
		//list FK
 private List<ObjectScoreInfo> _objectScoreInfos;
 private List<PictrueInformationInfo> _pictrueInformationInfos;
 private List<ShopInformationInfo> _shopInformationInfos;
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
		*�÷��б���Json��ʽ����
		*/
		public String getScoreList()
		{
		
			 return _scoreList; 
		}
		/**
		*�÷��б���Json��ʽ����
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
 
	
		



