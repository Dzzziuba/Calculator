package com.dziuba.hello;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class StatelessPage extends WebPage {

    Evaluator evaluator = new Evaluator();

    public StatelessPage() {
	add(new CalcForm("form"));
    }

    class CalcForm extends StatelessForm {
	private String inputField;
	private String errorInfo;

	public CalcForm(String id) {
	    super(id);
	    setDefaultModel(new CompoundPropertyModel(this));

	    final Label error = new Label("errorInfo");
	    final TextField inputPanel = new TextField("inputField");

	    error.setOutputMarkupId(true);
	    error.setOutputMarkupPlaceholderTag(true);

	    inputPanel.setOutputMarkupId(true);
	    inputPanel.setOutputMarkupPlaceholderTag(true);

	    add(inputPanel);
	    add(error);

	    this.add(new AjaxButton("result", this) {
		@Override
		protected void onSubmit(AjaxRequestTarget target, Form<?> arg1) {
		    super.onSubmit();
		    target.addComponent(error);
		    target.addComponent(inputPanel);
		}
	    });
	}

	public void onSubmit() {
	    try {
		inputField = evaluator.evaluate(inputField);
		errorInfo = "";
	    } catch (EvaluationException ex) {
		errorInfo = "Sorry, can't calc because of: " + ex.getMessage();
	    }
	}
    }
}