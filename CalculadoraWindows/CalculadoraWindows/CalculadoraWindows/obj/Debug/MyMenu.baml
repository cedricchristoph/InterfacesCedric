   M S B A M L   `   `   `  ����M  ICalculadoraWindows, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null7 clr-namespace:CalculadoraWindowsCalculadoraWindows  5          CalculadoraWindows.MyMenu   5      \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      2local clr-namespace:CalculadoraWindows     5        N� Title$  	Historial��5	       � 	Resources 5
         DarkButtonStyle �� 
TargetType �� Property  WindowTextBrush �� Value'  !System.Windows.Shell.WindowChrome �� 
TargetType ��Name J� SnapsToDevicePixels ��Name	 �� Triggers
 P� Property P� Value �� 
TargetName��%�  &	        �� 5   
   " ��6(   .�5      ��  � ��# �  6+   �� 5       � ��$ 0q�6(   �� 5        �@ IsHitTestVisibleInChrome . 6F   �� 5       � �� .  6*   �� 5       � �� 5      �� 5      " ��6&   .R�5      �� $ border��5      ���	#FF1B1B1B$��0q�5       . ._�5      �� $ contentPresenter��5   !   $��0q�5   !   $��Center=�5   !   $��Center=�5   !   |�.  ��. 5   !   5       	 5!      P� 5"      
 �@J�IsMouseOver . . �5#   "   �� $ border��6)    � ��
 �   �6S   5$      P� 5%      
 � �� . . �5&   "   �� $ border��6)    � �� �	#FF1717176S   5'      5)      5+      5,      5.      .��50      �  � ColumnDefinitions 51   
   �� 52      $
��Auto �6    � RowDefinitions 54   
   �� 55      $
��32px �6   �� 56      $
��Auto �6   .+�59   
   � $��0��6    5:      �� 5;      $��400px �6#   �� 5<      $
��Auto �6#   5>      � 5@   
   $��1��6   $
��Auto��6   $	��615��6)   $��0,0,-92,-612q�66   $	��Top=�6L   .+�5A      �� -   5         �� EdgeMode$ Aliased=�5B      #��[  5C      
������� J� RenderTransformOrigin$ 1.241,-0.319&�5E      $��10,10,0,537q�5F      $��Calculadora Estándar��6&   $��0��5G      $
��Left=�5H      $	��483��6,   $
��68px��68   $��20(�6F   $
��Bold"�6T   6f   �� 5I      -   5        $ Aliased=�5J      #��[  5K      
�������$ 1.241,-0.319&�5M      $��10,83,0,464q�5N      $��Conversor Monedas��6&   $��0��5O      $
��Left=�5P      $	��483��6,   $
��68px��68   $��20(�6F   $
��Bold"�6T   6f   5R      5T      5U      