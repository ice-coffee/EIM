package com.zn.zxw.intelligencize.model;


import java.io.Serializable;
  	import java.util.List;
/**
	*备注:
	*/
    public class OfUser implements Serializable
    {
        public OfUser()
        { }
		
		
        /**
		*
		*/
		private String   _username;//
		/**
		*
		*/
		private String   _plainPassword;//
		/**
		*
		*/
		private String   _encryptedPassword;//
		/**
		*
		*/
		private String   _name;//
		/**
		*
		*/
		private String   _email;//
		/**
		*
		*/
		private String   _creationDate;//
		/**
		*
		*/
		private String   _modificationDate;//
		/**
		*
		*/
		private byte[]   _headPic;//
		/**
		*
		*/
		private String   _coord;//
		
		//list FK
		
		/**
		 * 联系方式集合
		 */
		private List<UserContactInfo> _userContactInfos;
		
		
		public List<UserContactInfo> getUserContactInfos() {
			return _userContactInfos;
		}
		public void setUserContactInfos(List<UserContactInfo> _userContactInfos) {
			this._userContactInfos = _userContactInfos;
		}
		/**
		*
		*/
		public String getusername()
		{
		
			 return _username; 
		}
		/**
		*
		*/
		public void  setusername (String  username )
		{
			_username = username ;
		}
		
		
		/**
		*
		*/
		public String getplainPassword()
		{
		
			 return _plainPassword; 
		}
		/**
		*
		*/
		public void  setplainPassword (String  plainPassword )
		{
			_plainPassword = plainPassword ;
		}
		
		
		/**
		*
		*/
		public String getencryptedPassword()
		{
		
			 return _encryptedPassword; 
		}
		/**
		*
		*/
		public void  setencryptedPassword (String  encryptedPassword )
		{
			_encryptedPassword = encryptedPassword ;
		}
		
		
		/**
		*
		*/
		public String getname()
		{
		
			 return _name; 
		}
		/**
		*
		*/
		public void  setname (String  name )
		{
			_name = name ;
		}
		
		
		/**
		*
		*/
		public String getemail()
		{
		
			 return _email; 
		}
		/**
		*
		*/
		public void  setemail (String  email )
		{
			_email = email ;
		}
		
		
		/**
		*
		*/
		public String getcreationDate()
		{
		
			 return _creationDate; 
		}
		/**
		*
		*/
		public void  setcreationDate (String  creationDate )
		{
			_creationDate = creationDate ;
		}
		
		
		/**
		*
		*/
		public String getmodificationDate()
		{
		
			 return _modificationDate; 
		}
		/**
		*
		*/
		public void  setmodificationDate (String  modificationDate )
		{
			_modificationDate = modificationDate ;
		}
		
		
		/**
		*
		*/
		public byte[] getHeadPic()
		{
		
			 return _headPic; 
		}
		/**
		*
		*/
		public void  setHeadPic (byte[]  HeadPic )
		{
			_headPic = HeadPic ;
		}
		
		
		/**
		*
		*/
		public String getCoord()
		{
		
			 return _coord; 
		}
		/**
		*
		*/
		public void  setCoord (String  Coord )
		{
			_coord = Coord ;
		}
		
		
				//list FK
  }
 
	
		



