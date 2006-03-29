package wicket.extensions.ajax.markup.html.tabs;

import java.util.List;

import wicket.ajax.AjaxRequestTarget;
import wicket.ajax.markup.html.AjaxFallbackLink;
import wicket.extensions.markup.html.tabs.TabbedPanel;
import wicket.markup.html.WebMarkupContainer;

/**
 * Ajaxified version of the tabbed panel. Uses AjaxFallbackLink instead of
 * regular wicket links so it can update itself inplace.
 * 
 * @author Igor Vaynberg (ivaynberg)
 * 
 */
public class AjaxTabbedPanel extends TabbedPanel
{
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param tabs
	 */
	public AjaxTabbedPanel(String id, List tabs)
	{
		super(id, tabs);
		setOutputMarkupId(true);
	}

	protected WebMarkupContainer newLink(String linkId, final int index)
	{
		return new AjaxFallbackLink(linkId)
		{

			private static final long serialVersionUID = 1L;

			public void onClick(AjaxRequestTarget target)
			{
				setSelectedTab(index);
				if (target != null)
				{
					target.addComponent(AjaxTabbedPanel.this);
				}
			}

		};
	}


}
