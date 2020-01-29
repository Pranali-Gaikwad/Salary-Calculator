package com.example.myapplication;

public class UsersOfCalculator {
    private int _id;
    private String _name;
    private String _ctc;
    private String _taxp;
    private String _epfp;
    private String _tax;
    private String _epf;
    private String _net;

    public UsersOfCalculator() {
    }

    public UsersOfCalculator(String name, String ctc, String taxp, String epfp, String tax, String epf, String net) {
        this._name = name;
        this._ctc= ctc;
        this._taxp = taxp;
        this._epfp = epfp;
        this._tax = tax;
        this._epf = epf;
        this._net = net;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public String get_ctc() {
        return _ctc;
    }

    public void set_ctc(String _ctc) {
        this._ctc = _ctc;
    }

    public String get_taxp() {
        return _taxp;
    }

    public String get_epfp() {
        return _epfp;
    }

    public String get_tax() {
        return _tax;
    }

    public String get_epf() {
        return _epf;
    }

    public String get_net() {
        return _net;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_taxp(String _taxp) {
        this._taxp = _taxp;
    }

    public void set_epfp(String _epfp) {
        this._epfp = _epfp;
    }

    public void set_tax(String _tax) {
        this._tax = _tax;
    }

    public void set_epf(String _epf) {
        this._epf = _epf;
    }

    public void set_net(String _net) {
        this._net = _net;
    }
}
