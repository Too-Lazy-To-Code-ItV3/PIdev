package com.example.userjfx;

import Interfaces.CategorieInterface;
import Interfaces.CommentInterface;
import Interfaces.PostInterface;
import Services.CategorieService;
import Services.CommentService;
import Services.PostService;

public class Main {
    public static void main(String[] args){
        CategorieInterface cat = new CategorieService();
        CommentInterface com = new CommentService();
        PostInterface stmt = new PostService();

    };
}
