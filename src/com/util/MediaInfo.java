package com.util;

import java.lang.reflect.Method;
import java.util.Map;

import com.sun.jna.FunctionMapper;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.WString;

public class MediaInfo {
	static{
		try{
			String os = System.getProperty("os.name");
			if(os != null && !os.toLowerCase().startsWith("windows") && !os.toLowerCase().startsWith("mac"))
				NativeLibrary.getInstance("zen");
		}catch(LinkageError e){
			
		}
	}
	
	interface MediaInfoDLL_Internal extends Library{
		MediaInfoDLL_Internal INSTANCE = (MediaInfoDLL_Internal) Native.loadLibrary("mediaainfo",MediaInfoDLL_Internal.class, singletonMap(OPTION_FUNCTION_MAPPER, new FunctionMapper() {
			
			@Override
			public String getFunctionName(NativeLibrary lib, Method method) {
				// TODO Auto-generated method stub
				return "MdediaInfo_" + method.getName();
			}
		}));
		Pointer New();
		void Delete(Pointer Handle);
		
		int Open(Pointer Handle, WString file);
		void  Close(Pointer Handle);
		
		WString inform(Pointer Handle, int Reserved);
		WString Get(Pointer Handle, int StreamKind, int StreamNumber, WString parameter, int infoKind, int searchKind);
		WString GetI(Pointer Handle, int StreamKind, int StreamNumber, int parameterIndex, int infokind);
		int Count_Get(Pointer Handle, int StreamKind, int StreamNumber);
		WString Option (Pointer Handle, WString option, WString value);
	}
	private Pointer Handle;
	
	public enum StreamKind{
		General,
		Video,
		Audio,
		Text,
		Chapters,
		image,
		Menu;
	}
	
	public enum InfoKind{
		Name,
		Text,
		measure,
		Option,
		name_Text,
		Name_Text,
		measure_Text,
		Info,
		HowTo,
		Domain;
	}
	
	public MediaInfo(){
		Handle = MediaInfoDLL_Internal.INSTANCE.New();
	}
	
	protected static Map singletonMap(String optionFunctionMapper, FunctionMapper functionMapper) {
		// TODO Auto-generated method stub
		return null;
	}

	public void dispose(){
		if(Handle == null)
			throw new IllegalStateException();
		MediaInfoDLL_Internal.INSTANCE.Delete(Handle);
	}
	
	@Override
	protected void finalize() throws Throwable{
		if(Handle != null)
			dispose();
	}
	
	public int Open(String File_Name){
		return MediaInfoDLL_Internal.INSTANCE.Open(Handle, new WString(File_Name));
	}
	
	public void Close(){
		MediaInfoDLL_Internal.INSTANCE.Close(Handle);
	}
	
	public String Inform(){
		return MediaInfoDLL_Internal.INSTANCE.inform(Handle, 0).toString();
	}
	
	public String Get(StreamKind StreamKind, int StreamNumber, String parameter){
		return Get(StreamKind, StreamNumber, parameter, InfoKind.Text, InfoKind.Name);
	}
	
	public String Get(StreamKind StreamKind, int StreamNumber, String parameter, InfoKind infoKind){
		return Get(StreamKind, StreamNumber, parameter, infoKind, InfoKind.Name);
	}
	
	public String Get(StreamKind StreamKind, int StreamNumber, String parameter, InfoKind infoKind, InfoKind searchKind){
		return MediaInfoDLL_Internal.INSTANCE.Get(Handle, StreamKind.ordinal(), StreamNumber, new WString(parameter), infoKind.ordinal(), searchKind.ordinal()).toString();
	}
	
	public String get(StreamKind StreamKind, int StreamNumber, int parameterIndex){
		return Get(StreamKind, StreamNumber, parameterIndex, InfoKind.Text);
	}
	
	public String Get(StreamKind StreamKind, int StreamNumber, int parameterIndex, InfoKind  infoKind){
		return MediaInfoDLL_Internal.INSTANCE.GetI(Handle, StreamKind.ordinal(), StreamNumber, parameterIndex, infoKind.ordinal()).toString();
	}
	
	public int Count_Get(StreamKind StreamKind){
		return MediaInfoDLL_Internal.INSTANCE.Count_Get(Handle, StreamKind.ordinal(), -1);
	}
	
	public int Count_Get(StreamKind StreamKind, int StreamNumber){
		return MediaInfoDLL_Internal.INSTANCE.Count_Get(Handle, StreamKind.ordinal(), StreamNumber);
	}
	
	public String Option(String Option){
		return MediaInfoDLL_Internal.INSTANCE.Option(Handle, new WString(Option), new WString("")).toString();
	}
	
	public String Option(String Option, String Value){
		return MediaInfoDLL_Internal.INSTANCE.Option(Handle, new WString(Option), new WString(Value)).toString();
	}
	
	public static String Option_Static(String Option){
		return MediaInfoDLL_Internal.INSTANCE.Option(MediaInfoDLL_Internal.INSTANCE.New(), new WString(Option), new WString("")).toString();
	}
	
	public static String Option_Static(String Option, String Value){
		return MediaInfoDLL_Internal.INSTANCE.Option(MediaInfoDLL_Internal.INSTANCE.New(), new WString(Option), new WString(Value)).toString();
	}
	
	
}
