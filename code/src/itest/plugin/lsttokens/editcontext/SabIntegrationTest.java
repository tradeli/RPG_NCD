/*
 * Copyright (c) 2009 Tom Parker <thpr@users.sourceforge.net>
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
package plugin.lsttokens.editcontext;

import pcgen.cdom.base.CDOMObject;
import pcgen.core.Ability;
import pcgen.persistence.PersistenceLayerException;
import pcgen.rules.persistence.CDOMLoader;
import pcgen.rules.persistence.token.CDOMPrimaryToken;
import plugin.lsttokens.SabLst;
import plugin.lsttokens.editcontext.testsupport.AbstractTypeSafeListIntegrationTestCase;
import plugin.lsttokens.testsupport.CDOMTokenLoader;

public class SabIntegrationTest extends
		AbstractTypeSafeListIntegrationTestCase<CDOMObject>
{

	static SabLst token = new SabLst();
	static CDOMTokenLoader<CDOMObject> loader = new CDOMTokenLoader<CDOMObject>();

	@Override
	public Class<Ability> getCDOMClass()
	{
		return Ability.class;
	}

	@Override
	public CDOMLoader<CDOMObject> getLoader()
	{
		return loader;
	}

	@Override
	public CDOMPrimaryToken<CDOMObject> getToken()
	{
		return token;
	}

	@Override
	public boolean isClearLegal()
	{
		return true;
	}

	@Override
	public Object getConstant(String string)
	{
		return string;
	}

	@Override
	public char getJoinCharacter()
	{
		return '|';
	}

	@Override
	public boolean isClearDotLegal()
	{
		return false;
	}

	@Override
	protected boolean requiresPreconstruction()
	{
		return false;
	}

	@Override
	public void testRoundRobinDotClearJoinedOne()
			throws PersistenceLayerException
	{
		// TODO No action for now, since Sab doesn't join
	}

	@Override
	public void testRoundRobinDotClearJoinedTwo()
			throws PersistenceLayerException
	{
		// TODO No action for now, since Sab doesn't join
	}
	
	
}
