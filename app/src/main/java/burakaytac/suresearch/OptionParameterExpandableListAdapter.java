package burakaytac.suresearch;

import android.content.Context;
import android.graphics.Path;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;

import burakaytac.suresearch.model.Option;
import burakaytac.suresearch.model.OptionParameter;

public class OptionParameterExpandableListAdapter extends BaseExpandableListAdapter {

    public static class GroupViewHolder extends RecyclerView.ViewHolder{

        ExtendedEditText optionName;
        Button addParameter;
        Option currentOption;

        public GroupViewHolder(View itemView) {
            super(itemView);
            optionName = itemView.findViewById(R.id.option_name);
            addParameter = itemView.findViewById(R.id.add_option_parameter);

            optionName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(s == null || s.equals("")) return;
                    currentOption.setText(s.toString());
                }
            });


        }
    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder{

        ExtendedEditText optionParameterName, optionParameterValue;
        OptionParameter currentOptionParamater;

        public ChildViewHolder(View itemView) {
            super(itemView);
            optionParameterName = itemView.findViewById(R.id.parameter_name);
            optionParameterValue = itemView.findViewById(R.id.parameter_value);

            optionParameterName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(s == null || s.equals("")) return;
                    currentOptionParamater.setText(s.toString());
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
                    if(s == null || s.equals("")) return;
                    currentOptionParamater.setDefaultValue(s.toString());
                }
            });
        }

    }

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
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        GroupViewHolder groupViewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_edit_option, parent, false);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder)convertView.getTag();
        }

        groupViewHolder.currentOption = options.get(groupPosition);

        ExpandableListView mExpandableListView = (ExpandableListView)parent;
        mExpandableListView.expandGroup(groupPosition);

        groupViewHolder.optionName.setText(options.get(groupPosition).getText());

        groupViewHolder.addParameter.setOnClickListener(new View.OnClickListener() {
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

        ChildViewHolder childViewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_edit_option_parameter, parent, false);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder)convertView.getTag();
        }

        childViewHolder.currentOptionParamater = options.get(groupPosition).getOptionParameters().get(childPosition);

        childViewHolder.optionParameterName.setText(options.get(groupPosition).getOptionParameters().get(childPosition).getText());
        childViewHolder.optionParameterValue.setText(options.get(groupPosition).getOptionParameters().get(childPosition).getDefaultValue());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
