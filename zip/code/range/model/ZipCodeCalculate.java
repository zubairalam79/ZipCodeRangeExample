package zip.code.range.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ZipCodeCalculate {

	private static ArrayList<ZipCodeRange> zipRangeList = new ArrayList<ZipCodeRange>();

	public static void main(String[] args) 
	{

		ZipCodeRange zipRange1 = new ZipCodeRange(12, 15);
		ZipCodeRange zipRange2 = new ZipCodeRange(14, 23);
		ZipCodeRange zipRange3 = new ZipCodeRange(13, 16);
		ZipCodeRange zipRange4 = new ZipCodeRange(21, 23);
		ZipCodeRange zipRange5 = new ZipCodeRange(17, 35);
		

		AddRange(zipRange1);
		AddRange(zipRange2);
		AddRange(zipRange3);
		AddRange(zipRange4);
		AddRange(zipRange5);

		showZipRange();

	}

	public static void AddRange(ZipCodeRange zipRangeToAdd) 
	{
		if (zipRangeList.size() == 0)
		{
			zipRangeList.add(zipRangeToAdd);
		}
		else 
		{
			ListIterator<ZipCodeRange> iter = zipRangeList.listIterator();
			boolean add = true;
			while (iter.hasNext()) 
			{
				ZipCodeRange zipRange = iter.next();
				if (zipRange.getStart() <= zipRangeToAdd.getStart() && zipRange.getEnd() >= zipRangeToAdd.getEnd()) 
				{
					add = false;
				} 
				else if (zipRange.getStart() > zipRangeToAdd.getEnd() || zipRange.getEnd() < zipRangeToAdd.getEnd()) 
				{
					add = true;
				} 
				else 
				{
					if (zipRange.getStart() < zipRangeToAdd.getStart())
					{
						zipRangeToAdd.setStart(zipRange.getStart());
					}
					if (zipRange.getEnd() > zipRangeToAdd.getEnd())
					{
						zipRangeToAdd.setUpper(zipRange.getEnd());
					}
					iter.remove();
					add = true;
				}
			}
			if (add)
			{
				zipRangeList.add(zipRangeToAdd);
			}
		}
	}

	public static void showZipRange() 
	{
		if (zipRangeList.size() > 0) 
		{
			for (ZipCodeRange range : zipRangeList) 
			{
				System.out.println(range.toString());
			}
		}

	}

	public static int size() 
	{
		return zipRangeList.size();
	}

	public static List<ZipCodeRange> getZipRanges() 
	{
		return zipRangeList;
	}

	public static void clear() 
	{
		zipRangeList.clear();
	}
}
