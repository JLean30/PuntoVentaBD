                /*
                 * To change this license header, choose License Headers in Project Properties.
                 * To change this template file, choose Tools | Templates
                 * and open the template in the editor.
                 */
                   package modelo;


                    /**
                     *
                     * @author JeanC
                     */
                           public class Provedor  {

                            private String cedulaJuridica,nombreComercial,contacto,direccion,moneda,montoCredito;
                            private double diasCredito;

                            public void setCedulaJuridica(String valor){
                                this.cedulaJuridica = valor;
                            }

                            public void setNombreComercial(String valor){
                                this.nombreComercial = valor;
                            }

                            public void setContacto(String valor){
                                this.contacto = valor;
                            }

                            public void setDireccion(String valor){
                                this.direccion = valor;
                            }

                            public void setMoneda(String valor){
                                this.moneda = valor;
                            }
                            public void setDiasCredito(double valor){
                                this.diasCredito = valor;
                            }

                            public void setMontoCredito(String valor){
                                this.montoCredito = valor;
                            }

                            public String getCedulaJuridica(){
                                return this.cedulaJuridica;

                            }

                            public String getNombreComercial(){
                                return this.nombreComercial;

                            }

                            public String getContacto(){
                                return this.contacto;

                            }

                            public String getDireccion(){
                                return this.direccion;

                            }

                            public String getMoneda(){
                                return this.moneda;

                            }

                            public double getDiasCredito(){
                                return this.diasCredito;

                            }

                            public String getMontoCredito(){
                                return this.montoCredito;

                            }
                            
                            public Provedor(String pCed,String pNombComer,String pContacto,String pDireccion,String pMontoCred,double pDias,String pMoneda){
                                this.setCedulaJuridica(pCed);
                                this.setNombreComercial(pNombComer);
                                this.setContacto(pContacto);
                                this.setDireccion(pDireccion);
                                this.setMontoCredito(pMontoCred);
                                this.setDiasCredito(pDias);
                                this.setMoneda(pMoneda);
                            }
                            
                            public Provedor(){
                                this.cedulaJuridica="";
                                this.nombreComercial="";
                                this.contacto="";
                                this.direccion="";
                                this.montoCredito="";
                                this.diasCredito=0.0;
                                this.moneda="";
                            }
                        }
                    




                            




