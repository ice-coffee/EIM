package csdn.shimiso.eim.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketIDFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Registration;

import csdn.shimiso.eim.manager.XmppConnectionManager;
/**
 * xmpp����
 */
public class XmppService{
	/** 
     * ɾ����ǰ�û� 
     * @param connection 
     * @return 
     */  
    public static boolean deleteAccount(XMPPConnection connection)  
    {  
        try {  
            connection.getAccountManager().deleteAccount();         
            return true;  
        } catch (Exception e) {  
            return false;  
        }  
    }  
//	/**
//	 * ������������Ϣ <RosterGroup>
//	 * @return List(RosterGroup)
//	 */
//	public static List<RosterGroup> getGroups(Roster roster) {
//		List<RosterGroup> groupsList = new ArrayList<RosterGroup>();
//		Collection<RosterGroup> rosterGroup = roster.getGroups();
//		Iterator<RosterGroup> i = rosterGroup.iterator();
//		while (i.hasNext())
//			groupsList.add(i.next());
//		return groupsList;
//	}

//	/**
//	 * ������Ӧ(groupName)����������û�<RosterEntry>
//	 * @return List(RosterEntry)
//	 */
//	public static List<RosterEntry> getEntriesByGroup(Roster roster,
//			String groupName) {
//		List<RosterEntry> EntriesList = new ArrayList<RosterEntry>();
//		RosterGroup rosterGroup = roster.getGroup(groupName);
//		Collection<RosterEntry> rosterEntry = rosterGroup.getEntries();
//		Iterator<RosterEntry> i = rosterEntry.iterator();
//		while (i.hasNext())
//			EntriesList.add(i.next());
//		return EntriesList;
//	}

	/**
	 * ���������û���Ϣ <RosterEntry>
	 * @return List(RosterEntry)
	 */
	public static List<RosterEntry> getAllEntries(Roster roster) {
		List<RosterEntry> EntriesList = new ArrayList<RosterEntry>();
		Collection<RosterEntry> rosterEntry = roster.getEntries();
		Iterator<RosterEntry> i = rosterEntry.iterator();
		while (i.hasNext())
			EntriesList.add(i.next());
		return EntriesList;
	}
	
//	
//	/** 
//     * ����һ���� 
//     */ 
//	public static boolean addGroup(Roster roster,String groupName)  
//    {  
//        try {  
//            roster.createGroup(groupName);  
//            return true;  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//            return false;  
//        }  
//    }  
//      
//    /** 
//     * ɾ��һ���� 
//     */  
//    public static boolean removeGroup(Roster roster,String groupName)  
//    {  
//        return false;  
//    }
//    
    /**
	 * ���һ������  �޷���
	 */
	public static boolean addUser(Roster roster,String userName,String name)
	{
		try {
			roster.createEntry(userName, name, null);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
//	/**
//	 * ���һ�����ѵ�����
//	 * @param roster
//	 * @param userName
//	 * @param name
//	 * @return
//	 */
//	public static boolean addUsers(Roster roster,String userName,String name,String groupName)
//	{
//		try {
//			roster.createEntry(userName, name,new String[]{ groupName});
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		
//	}
	
	/**
	 * ɾ��һ������
	 * @param roster
	 * @param userJid
	 * @return
	 */
	public static boolean removeUser(Roster roster,String userJid)
	{
		try {
			RosterEntry entry = roster.getEntry(userJid);
			roster.removeEntry(entry);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
//	
//	/**
//     * ��һ��������ӵ�һ������
//     * @param userJid
//     * @param groupName
//     */
//    public static void addUserToGroup(final String userJid, final String groupName,
//            final XMPPConnection connection) {
//            	RosterGroup group = connection.getRoster().getGroup(groupName);
//                // ������Ѿ����ھ���ӵ�����飬�����ڴ���һ����
//                RosterEntry entry = connection.getRoster().getEntry(userJid);
//                try {
//                    if (group != null) {
//                        if (entry != null)
//                            group.addEntry(entry);
//                    } else {
//                        RosterGroup newGroup = connection.getRoster().createGroup("�ҵĺ���");
//                        if (entry != null)
//                            newGroup.addEntry(entry);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//    }

//    /**
//     * ��һ�����Ѵ�����ɾ��
//     * @param userJid
//     * @param groupName
//     */
//    public static void removeUserFromGroup(final String userJid,final String groupName, final XMPPConnection connection) {
//            RosterGroup group = connection.getRoster().getGroup(groupName);
//            if (group != null) {
//                try {
//                	RosterEntry entry = connection.getRoster().getEntry(userJid);
//                    if (entry != null)
//                        group.removeEntry(entry);
//                } catch (XMPPException e) {
//                    e.printStackTrace();
//                }
//            }
//     }
    
    /** 
     * �޸����� 
     * @param connection 
     * @param status 
     */  
    public static void changeStateMessage(final XMPPConnection connection,final String status)  
    {  
        Presence presence = new Presence(Presence.Type.available);  
        presence.setStatus(status);  
        connection.sendPacket(presence);      
    }
    
	public static String getUsername(String fullUsername){
		return fullUsername.split("@")[0];
	}
	
    
    
}
