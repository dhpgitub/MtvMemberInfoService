select     Event_STORE_SK, Event_Internal_Id, Event_External_Id, Event_Parent_Id, 
Event_Identifier_Value, Event_Identifier_Type, Event_Src_COMP, EVENT_CREATION_TS
from DS_EVENT_MGMT.EVENT_STORE    
where     Event_status = 'S'             