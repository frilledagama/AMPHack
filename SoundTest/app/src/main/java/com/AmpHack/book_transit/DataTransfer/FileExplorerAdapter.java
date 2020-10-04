package com.AmpHack.book_transit.DataTransfer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.AmpHack.book_transit.R;


//Adapter used for printing ArrayList to ListView
public class FileExplorerAdapter extends ArrayAdapter<FileExplorerElement>{

    private Context mContext;
    private List<FileExplorerElement> myList;

    public FileExplorerAdapter(@NonNull Context context, ArrayList<FileExplorerElement> list) {
        //Constructor of ArrayAdapter. Resource is set in getView so now is passed 0
        super(context, 0, list);
        this.mContext=context;
        this.myList=list;
    }

    //Method called for showing data from ArrayList to view
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem=convertView;
        if(listItem==null){
            listItem= LayoutInflater.from(mContext).inflate(R.layout.storage_file_list_element, parent,
                    false);
        }
        FileExplorerElement Elem= myList.get(position);
        //Set data to newly created view
        ((TextView) listItem.findViewById(R.id.fileName)).setText(Elem.getFileName());
        //3 types of elements in browser: back, file and folder
        if(Elem.isBack()){
            ImageView iv = listItem.findViewById(R.id.fileImage);
            iv.setImageResource(R.drawable.folder_back);
            ((TextView) listItem.findViewById(R.id.fileSize)).setText("");
        }
        else{
            if(Elem.isFile()){
                ImageView iv = listItem.findViewById(R.id.fileImage);
                iv.setImageResource(R.drawable.file_image);
                ((TextView) listItem.findViewById(R.id.fileSize)).setText(Elem.getFileSize());
            }
            else{
                ImageView iv = listItem.findViewById(R.id.fileImage);
                iv.setImageResource(R.drawable.folder_image);
                ((TextView) listItem.findViewById(R.id.fileSize)).setText("");
            }
        }
        return listItem;
    }
}
