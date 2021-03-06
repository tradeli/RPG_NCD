/*
 * Copyright 2015 (C) Tom Parker <thpr@users.sourceforge.net>
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package pcgen.output.model;

import pcgen.base.geom.OrderedPair;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;

/**
 * A OrderedPairModel wraps a OrderedPair object into a TemplateScalarModel and
 * TemplateHashModel
 */
public class OrderedPairModel implements TemplateScalarModel, TemplateHashModel
{
	/**
	 * The underlying OrderedPair object
	 */
	private final OrderedPair point;

	/**
	 * Constructs a new OrderedPairModel with the given underlying OrderedPair
	 * 
	 * @param cat
	 *            The OrderedPair this OrderedPairModel wraps
	 */
	public OrderedPairModel(OrderedPair point)
	{
		if (point == null)
		{
			throw new IllegalArgumentException("OrderedPair cannot be null");
		}
		this.point = point;
	}

	/*
	 * @see freemarker.template.TemplateScalarModel#getAsString()
	 */
	@Override
	public String getAsString() throws TemplateModelException
	{
		return point.toString();
	}

	@Override
	public TemplateModel get(String key) throws TemplateModelException
	{
		if (key.equalsIgnoreCase("x"))
		{
			ObjectWrapper.SIMPLE_WRAPPER.wrap(point.getPreciseX());
		}
		else if (key.equalsIgnoreCase("y"))
		{
			ObjectWrapper.SIMPLE_WRAPPER.wrap(point.getPreciseY());
		}
		throw new TemplateModelException(
			"object of type OrderedPair did not have output of type " + key);
	}

	@Override
	public boolean isEmpty() throws TemplateModelException
	{
		return false;
	}

}
