/*
 * Copyright (c) 2008 Tom Parker <thpr@users.sourceforge.net>
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 */
package plugin.lsttokens.template;

import pcgen.cdom.enumeration.IntegerKey;
import pcgen.core.PCTemplate;
import pcgen.rules.context.LoadContext;
import pcgen.rules.persistence.token.CDOMPrimaryToken;
import pcgen.util.Logging;

/**
 * Class deals with NONPP Token
 */
public class NonppToken implements CDOMPrimaryToken<PCTemplate>
{

	public String getTokenName()
	{
		return "NONPP";
	}

	public boolean parse(LoadContext context, PCTemplate template, String value)
	{
		try
		{
			Integer nonpp = Integer.valueOf(value);
			if (nonpp.intValue() > 0)
			{
				Logging.errorPrint("Non-Proficiency Penalty must be "
						+ "less than or equal to zero: " + value);
				return false;
			}
			context.getObjectContext().put(template, IntegerKey.NONPP, nonpp);
		}
		catch (NumberFormatException nfe)
		{
			Logging.errorPrint("Non-Proficiency Penalty must be a number "
					+ "less than or equal to zero: " + value);
			return false;
		}
		return true;
	}

	public String[] unparse(LoadContext context, PCTemplate pct)
	{
		Integer nonpp = context.getObjectContext().getInteger(pct,
				IntegerKey.NONPP);
		if (nonpp == null)
		{
			return null;
		}
		if (nonpp.intValue() > 0)
		{
			context.addWriteMessage("Non-Proficiency Penalty must be "
					+ "less than or equal to zero: " + nonpp);
			return null;
		}
		return new String[] { nonpp.toString() };
	}

	public Class<PCTemplate> getTokenClass()
	{
		return PCTemplate.class;
	}
}
