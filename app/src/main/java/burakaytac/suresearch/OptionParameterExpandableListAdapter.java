package burakaytac.suresearch;

import android.content.Context;
import android.graphics.Path;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;

import burakaytac.suresearch.model.Option;
import burakaytac.suresearch.model.OptionParameter;

public class OptionParameterExpandableListAdapter extends BaseExpandableListAdapter {
    ArrayList<Option> options;

    public void addData(Option option) {
        options.add(option);
        notifyDataSetChanged();
    }

    public OptionParameterExpandableListAdapter(ArrayList<Option> options) {
        this.options = options;
    }

    @Override
    public int getGroupCount() {
        return options.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return options.get(groupPosition).getOptionParameters().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return options.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return options.get(groupPosition).getOptionParameters().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final EditText optionName;
        Button addParameter;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_edit_option, null);
        }

        optionName = convertView.findViewById(R.id.option_name);

        optionName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionName.requestFocus();
            }
        });

        optionName.setText(options.get(groupPosition).getText());
        optionName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println(options.get(groupPosition).getOptionParameters().size());
                options.get(groupPosition).setText(s.toString());
            }
        });
        addParameter = convertView.findViewById(R.id.add_option_parameter);
        addParameter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                options.get(groupPosition).getOptionParameters().add(new OptionParameter("","", null));
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        EditText optionParameterName, optionParameterValue;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_edit_option_parameter, null);
        }

        optionParameterName = convertView.findViewById(R.id.parameter_name);
        optionParameterValue = convertView.findViewById(R.id.parameter_value);

        optionParameterName.setText(options.get(groupPosition).getOptionParameters().get(childPosition).getText());
        optionParameterValue.setText(options.get(groupPosition).getOptionParameters().get(childPosition).getDefaultValue());

        optionParameterName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                options.get(groupPosition).getOptionParameters().get(childPosition).setText(s.toString());
            }
        });

        optionParameterValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                options.get(groupPosition).getOptionParameters().get(childPosition).setDefaultValue(s.toString());
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
